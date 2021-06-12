package com.emrullah.assessment.getir.base.dto.user;

import com.emrullah.assessment.getir.base.framework.AbstractGenericType;

public class CreateUserRequest extends AbstractGenericType {

    private String email;
    private String pwd;
    private Long dealerId;
    private String userTpCode;

    public CreateUserRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public String getUserTpCode() {
        return userTpCode;
    }

    public void setUserTpCode(String userTpCode) {
        this.userTpCode = userTpCode;
    }
}
