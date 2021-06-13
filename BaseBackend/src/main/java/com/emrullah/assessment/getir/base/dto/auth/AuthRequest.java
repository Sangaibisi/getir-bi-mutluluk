package com.emrullah.assessment.getir.base.dto.auth;

import com.emrullah.assessment.getir.base.framework.AbstractGenericType;

public class AuthRequest extends AbstractGenericType {

    private String email;
    private String password;

    public AuthRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}