package com.mkyong.common.controller.restclient;

public class LoginResponseModel {
    private String transactionId;

    public LoginResponseModel() {
    }

    public LoginResponseModel(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
