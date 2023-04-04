package com.psi.satrello.login.model;

public class ExceptionModel {

    private String message;
    private Integer status;

    public ExceptionModel(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

}
