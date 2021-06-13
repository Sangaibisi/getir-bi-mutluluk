package com.emrullah.assessment.getir.commerce.service.order;

import com.emrullah.assessment.getir.base.dto.order.MonthlyStaticRequest;
import com.emrullah.assessment.getir.base.dto.order.MonthlyStaticResponse;
import com.emrullah.assessment.getir.base.dto.order.OrderRequest;
import com.emrullah.assessment.getir.base.dto.order.OrderRequestItem;
import com.emrullah.assessment.getir.base.entity.customer.Customer;
import com.emrullah.assessment.getir.base.entity.order.LineItem;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.entity.product.Product;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions.OrderStatusType;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.repository.IOrderRepository;
import com.emrullah.assessment.getir.base.repository.IProductRepository;
import com.emrullah.assessment.getir.base.service.ICustomerService;
import com.emrullah.assessment.getir.base.service.IOrderService;
import com.emrullah.assessment.getir.base.service.IProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final ICustomerService customerService;
    private final IProductService productService;
    private final IProductRepository productRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository, ICustomerService customerService, IProductService productService, IProductRepository productRepository, MongoTemplate mongoTemplate) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.productRepository = productRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @Transactional
    public Order processNewOrder(OrderRequest orderRequest) throws OperationResultException {
        runRequestPreValidationSteps(orderRequest);

        Customer orderOwner = customerService.getByEmail(orderRequest.getOwner().getEmail());
        String orderShippingAddress = orderOwner.getAddresses().get(orderRequest.getOrderAddressType());

        if (StringUtils.isEmpty(orderShippingAddress))
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.BAD_REQUEST, "The customer has no record of the given address type."));

        Order newOrder = new Order(orderOwner, orderShippingAddress);

        for (OrderRequestItem orderRequestItem : orderRequest.getOrderRequestItems()) {
            Product product = productService.inquireProductByName(orderRequestItem.getProductName());

            //This must be thread safe cuz of the stock count needs consistency
            this.checkAndDecrementProductStockCount(product, orderRequestItem.getCount());

            LineItem orderItem = new LineItem(product, orderRequestItem.getCount().intValue());
            newOrder.addOrderItem(orderItem);
        }

        newOrder.setOrderStatusType(OrderStatusType.APPROVED);
        newOrder.calculateOrderTotalPrice();

        orderRepository.save(newOrder);

        return newOrder;
    }

    @Override
    public Order inquireOrderById(String orderId) throws OperationResultException {
        if (StringUtils.isEmpty(orderId))
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.BAD_REQUEST, "Not a valid id parameter"));

        return orderRepository.findById(orderId).orElseThrow(() -> new OperationResultException(OperationResult.createErrorResult(HttpStatus.NOT_FOUND, "Order cannot be found with given id :" + orderId)));
    }

    @Override
    public void checkAndDecrementProductStockCount(Product product, Long requiredCount) throws OperationResultException {
        if (product == null || product.getStockCount() < 0 || (product.getStockCount() - requiredCount) < 0)
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.METHOD_NOT_ALLOWED, "Out of stock"));

        product.setStockCount(product.getStockCount() - requiredCount);

        productRepository.save(product);
    }

    @Override
    public List<MonthlyStaticResponse> inquireMonthlyStatistics(MonthlyStaticRequest request) {
        /* Monthly order statistics mongo query
                 [{
                    $match: {
                        createdDate: {
                            $gte: ISODate('2020/06')
                        }
                    }
                }, {
                    $match: {
                        createdDate: {
                            $lte: ISODate('2022/07')
                        }
                    }
                }, {
                    $group: {
                        _id: {
                            month: {
                                $month: "$createdDate"
                            }
                        },
                        totalMonthlyOrderCount: {
                            $sum: 1
                        },
                        totalMonthlyPrice: {
                            $sum: "$calculatedOrderPrice"
                        }
                    }
                }]
         */

        ProjectionOperation dateProjection = Aggregation.project()
                .and("calculatedOrderPrice").as("calculatedOrderPrice")
                .and("createdDate").extractMonth().as("month");

        GroupOperation groupBy = Aggregation.group("month").first("month").as("month")
                .sum("calculatedOrderPrice").as("totalMonthlyPrice")
                .count().as("totalMonthlyOrderCount");

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(new Criteria("createdDate").gte(request.getsDate())),
                Aggregation.match(new Criteria("createdDate").lte(request.geteDate())),
                dateProjection,
                groupBy);

        //Convert the aggregation result into a List
        AggregationResults<MonthlyStaticResponse> groupResults = mongoTemplate.aggregate(aggregation, "order", MonthlyStaticResponse.class);

        return groupResults.getMappedResults();
    }

    @Override
    public Page<Order> inquireOrdersByOrderStatus(OrderStatusType orderStatus) {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        return orderRepository.findAllByOrderStatusType(orderStatus,firstPageWithTwoElements);
    }

    private void runRequestPreValidationSteps(OrderRequest orderRequest) throws OperationResultException {
        if (Objects.isNull(orderRequest) || Objects.isNull(orderRequest.getOwner()) || Objects.isNull(orderRequest.getOrderAddressType()) || Objects.isNull(orderRequest.getOrderRequestItems())) {
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.BAD_REQUEST, "Request is not valid. Fill the all required params."));
        }
    }
}
