package com.emrullah.assessment.getir.base.service;

import com.emrullah.assessment.getir.base.dto.order.OrderRequest;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;

public interface IOrderService {
    Order processNewOrder(OrderRequest orderRequest) throws OperationResultException;
}
