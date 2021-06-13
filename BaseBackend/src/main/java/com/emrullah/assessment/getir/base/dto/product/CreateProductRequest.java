package com.emrullah.assessment.getir.base.dto.product;

import com.emrullah.assessment.getir.base.framework.AbstractGenericType;

import java.math.BigDecimal;

public class CreateProductRequest extends AbstractGenericType {

    private String name;
    private String description;
    private BigDecimal price;
    private Long stockCount;

    public CreateProductRequest() {
    }

    public CreateProductRequest(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getStockCount() {
        return stockCount;
    }

    public void setStockCount(Long stockCount) {
        this.stockCount = stockCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
