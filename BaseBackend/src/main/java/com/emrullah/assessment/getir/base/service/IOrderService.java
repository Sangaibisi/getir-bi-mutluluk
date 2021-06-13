package com.emrullah.assessment.getir.base.service;

import com.emrullah.assessment.getir.base.dto.order.OrderRequest;
import com.emrullah.assessment.getir.base.entity.order.LineItem;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.entity.product.Product;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;

public interface IOrderService {
    Order processNewOrder(OrderRequest orderRequest) throws OperationResultException;
    Order inquireOrderById(String orderId) throws OperationResultException;
    void checkAndDecrementProductStockCount(Product product, Long requiredCount);
}