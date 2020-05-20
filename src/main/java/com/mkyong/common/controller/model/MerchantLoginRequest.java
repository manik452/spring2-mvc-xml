package com.mkyong.common.controller.model;

public class MerchantLoginRequest {
    private String password;

    public MerchantLoginRequest(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
