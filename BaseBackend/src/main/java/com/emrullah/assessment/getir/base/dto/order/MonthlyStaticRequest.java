package com.emrullah.assessment.getir.base.dto.order;

import com.emrullah.assessment.getir.base.framework.AbstractGenericType;

import java.util.Date;

public class MonthlyStaticRequest extends AbstractGenericType {
    private Date sDate;
    private Date eDate;

    public MonthlyStaticRequest() {
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }
}
