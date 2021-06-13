package com.emrullah.assessment.getir.commerce.service.order;

import com.emrullah.assessment.getir.base.dto.order.OrderRequest;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.repository.IOrderRepository;
import com.emrullah.assessment.getir.base.service.IOrderService;
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
}
