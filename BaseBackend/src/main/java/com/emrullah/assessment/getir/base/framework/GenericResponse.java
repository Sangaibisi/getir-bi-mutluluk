package com.emrullah.assessment.getir.base.framework;

import java.io.Serializable;

public class GenericResponse<T> implements Serializable {

    private int code;
    private String message = null;
    private T data;

    public GenericResponse(T t){
        this.data=t;
    }

    public GenericResponse(String message) {
        this.code = 0;
        this.message = message;
    }

    public GenericResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public GenericResponse(String message, T data) {
        this.code = 0;
        this.message = message;
        this.data = data;
    }

    public GenericResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
