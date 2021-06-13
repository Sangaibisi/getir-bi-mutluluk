package com.emrullah.assessment.getir.base.dto.order;

import com.emrullah.assessment.getir.base.dto.user.CreateUserRequest;
import com.emrullah.assessment.getir.base.framework.AbstractGenericType;

import java.util.List;

public class OrderRequest extends AbstractGenericType {

    private List<OrderRequestItem> orderRequestItems;
    private CreateUserRequest owner;
    private String shippedAddress;
    private String orderStatus;

    public OrderRequest() {
    }

    public List<OrderRequestItem> getOrderRequestItems() {
        return orderRequestItems;
    }

    public void setOrderRequestItems(List<OrderRequestItem> orderRequestItems) {
        this.orderRequestItems = orderRequestItems;
    }

    public CreateUserRequest getOwner() {
        return owner;
    }

    public void setOwner(CreateUserRequest owner) {
        this.owner = owner;
    }

    public String getShippedAddress() {
        return shippedAddress;
    }

    public void setShippedAddress(String shippedAddress) {
        this.shippedAddress = shippedAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
