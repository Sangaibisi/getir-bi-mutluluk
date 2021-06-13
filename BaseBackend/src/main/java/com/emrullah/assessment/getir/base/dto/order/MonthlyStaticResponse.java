package com.emrullah.assessment.getir.base.dto.order;

import com.emrullah.assessment.getir.base.framework.AbstractGenericType;

public class MonthlyStaticResponse extends AbstractGenericType {

    private Double totalMonthlyOrderCount;
    private Double totalMonthlyPrice;
    private String month;

    public MonthlyStaticResponse() {
    }

    public Double getTotalMonthlyOrderCount() {
        return totalMonthlyOrderCount;
    }

    public void setTotalMonthlyOrderCount(Double totalMonthlyOrderCount) {
        this.totalMonthlyOrderCount = totalMonthlyOrderCount;
    }

    public Double getTotalMonthlyPrice() {
        return totalMonthlyPrice;
    }

    public void setTotalMonthlyPrice(Double totalMonthlyPrice) {
        this.totalMonthlyPrice = totalMonthlyPrice;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
