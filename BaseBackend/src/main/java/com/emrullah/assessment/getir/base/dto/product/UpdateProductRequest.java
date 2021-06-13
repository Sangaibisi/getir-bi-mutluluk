package com.emrullah.assessment.getir.base.dto.product;

public class UpdateProductRequest extends CreateProductRequest {

    private Long currentStockCount;

    public UpdateProductRequest() {
    }

    public Long getCurrentStockCount() {
        return currentStockCount;
    }

    public void setCurrentStockCount(Long currentStockCount) {
        this.currentStockCount = currentStockCount;
    }
}
