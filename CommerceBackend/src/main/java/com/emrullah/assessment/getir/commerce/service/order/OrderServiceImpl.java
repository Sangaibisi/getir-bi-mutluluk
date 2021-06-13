package com.emrullah.assessment.getir.commerce.service.order;

import com.emrullah.assessment.getir.base.dto.order.OrderRequest;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.repository.IOrderRepository;
import com.emrullah.assessment.getir.base.service.IOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;

    public OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order processNewOrder(OrderRequest orderRequest) throws OperationResultException {
        return null;
    }

    @Override
    public Order inquireOrderById(String orderId) throws OperationResultException {
        if(StringUtils.isEmpty(orderId))
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.BAD_REQUEST, "Not a valid id parameter"));

        return orderRepository.findById(orderId).orElseThrow(() -> new OperationResultException(OperationResult.createErrorResult(HttpStatus.NOT_FOUND, "Order cannot be found with given id :" + orderId)));
    }
}
