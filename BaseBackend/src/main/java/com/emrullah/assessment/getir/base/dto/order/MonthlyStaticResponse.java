package com.emrullah.assessment.getir.base.dto.order;

import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.AbstractGenericType;

import java.util.List;

public class MonthlyStaticResponse extends AbstractGenericType {
    List<Order> orderList;

    public MonthlyStaticResponse() {
    }

    public MonthlyStaticResponse(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
