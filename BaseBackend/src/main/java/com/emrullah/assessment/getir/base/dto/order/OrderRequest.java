package com.emrullah.assessment.getir.base.dto.order;

import com.emrullah.assessment.getir.base.dto.user.CreateUserRequest;
import com.emrullah.assessment.getir.base.framework.AbstractGenericType;
import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions;

import java.util.List;

public class OrderRequest extends AbstractGenericType {

    private List<OrderRequestItem> orderRequestItems;
    private CreateUserRequest owner;
    private GeneralEnumerationDefinitions.CustomerAddressType orderAddressType;

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

    public GeneralEnumerationDefinitions.CustomerAddressType getOrderAddressType() {
        return orderAddressType;
    }

    public void setOrderAddressType(GeneralEnumerationDefinitions.CustomerAddressType orderAddressType) {
        this.orderAddressType = orderAddressType;
    }
}
