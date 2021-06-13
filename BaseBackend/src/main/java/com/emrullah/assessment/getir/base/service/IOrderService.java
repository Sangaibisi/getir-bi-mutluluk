package com.emrullah.assessment.getir.base.service;

import com.emrullah.assessment.getir.base.dto.order.MonthlyStaticRequest;
import com.emrullah.assessment.getir.base.dto.order.MonthlyStaticResponse;
import com.emrullah.assessment.getir.base.dto.order.OrderRequest;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.entity.product.Product;
import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions.OrderStatusType;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {
    Order processNewOrder(OrderRequest orderRequest) throws OperationResultException;
    Order inquireOrderById(String orderId) throws OperationResultException;
    void checkAndDecrementProductStockCount(Product product, Long requiredCount);
    List<MonthlyStaticResponse> inquireMonthlyStatistics(MonthlyStaticRequest request);
    Page<Order> inquireOrdersByOrderStatus(OrderStatusType orderStatus);

}
