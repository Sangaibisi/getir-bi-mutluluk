package com.emrullah.assessment.getir.base.dto.order;

import com.emrullah.assessment.getir.base.framework.AbstractGenericType;

public class OrderRequestItem extends AbstractGenericType {

    private String productName;
    private Long count;

    public OrderRequestItem() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
