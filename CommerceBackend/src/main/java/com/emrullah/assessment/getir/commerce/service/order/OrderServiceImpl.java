package com.emrullah.assessment.getir.commerce.service.order;

import com.emrullah.assessment.getir.base.dto.order.OrderRequest;
import com.emrullah.assessment.getir.base.dto.order.OrderRequestItem;
import com.emrullah.assessment.getir.base.entity.customer.Customer;
import com.emrullah.assessment.getir.base.entity.order.LineItem;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.entity.product.Product;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.repository.IOrderRepository;
import com.emrullah.assessment.getir.base.repository.IProductRepository;
import com.emrullah.assessment.getir.base.service.ICustomerService;
import com.emrullah.assessment.getir.base.service.IOrderService;
import com.emrullah.assessment.getir.base.service.IProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final ICustomerService customerService;
    private final IProductService productService;
    private final IProductRepository productRepository;

    public OrderServiceImpl(IOrderRepository orderRepository, ICustomerService customerService, IProductService productService, IProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public Order processNewOrder(OrderRequest orderRequest) throws OperationResultException {
        runRequestPreValidationSteps(orderRequest);

        Customer orderOwner = customerService.getByEmail(orderRequest.getOwner().getEmail());
        String orderShippingAddress = orderOwner.getAddresses().get(orderRequest.getOrderAddressType());

        if(StringUtils.isEmpty(orderShippingAddress))
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.BAD_REQUEST, "The customer has no record of the given address type."));

        Order newOrder = new Order(orderOwner, orderShippingAddress);

        for (OrderRequestItem orderRequestItem : orderRequest.getOrderRequestItems()) {
            Product product = productService.inquireProductByName(orderRequestItem.getProductName());

            //This must be thread safe cuz of the stock count needs consistency
            this.checkAndDecrementProductStockCount(product, orderRequestItem.getCount());

            LineItem orderItem = new LineItem(product, orderRequestItem.getCount().intValue());
            newOrder.addOrderItem(orderItem);
        }

        newOrder.setOrderStatusType(GeneralEnumerationDefinitions.OrderStatusType.APPROVED);
        newOrder.calculateOrderTotalPrice();

        orderRepository.save(newOrder);

        return newOrder;
    }

    @Override
    public Order inquireOrderById(String orderId) throws OperationResultException {
        if(StringUtils.isEmpty(orderId))
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.BAD_REQUEST, "Not a valid id parameter"));

        return orderRepository.findById(orderId).orElseThrow(() -> new OperationResultException(OperationResult.createErrorResult(HttpStatus.NOT_FOUND, "Order cannot be found with given id :" + orderId)));
    }

    @Override
    public void checkAndDecrementProductStockCount(Product product, Long requiredCount) throws OperationResultException{
        if(product == null || product.getStockCount() < 0 || (product.getStockCount() - requiredCount) < 0)
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.METHOD_NOT_ALLOWED, "Out of stock"));

        product.setStockCount(product.getStockCount() - requiredCount);

        productRepository.save(product);
    }

    private void runRequestPreValidationSteps(OrderRequest orderRequest) throws OperationResultException{
        if(Objects.isNull(orderRequest) || Objects.isNull(orderRequest.getOwner()) || Objects.isNull(orderRequest.getOrderAddressType()) || Objects.isNull(orderRequest.getOrderRequestItems())){
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.BAD_REQUEST, "Request is not valid. Fill the all required params."));
        }
    }
}