package com.emrullah.assessment.getir.base.dto.order;

import com.emrullah.assessment.getir.base.framework.AbstractGenericType;

public class OrderRequestItem extends AbstractGenericType {

    private String productName;
    private String count;

    public OrderRequestItem() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
