package com.emrullah.assessment.getir.base.dto.product;

import java.math.BigDecimal;

public class UpdateProductRequest extends CreateProductRequest {

    private BigDecimal currentStockCount;

    public UpdateProductRequest() {
    }

    public BigDecimal getCurrentStockCount() {
        return currentStockCount;
    }

    public void setCurrentStockCount(BigDecimal currentStockCount) {
        this.currentStockCount = currentStockCount;
    }
}
