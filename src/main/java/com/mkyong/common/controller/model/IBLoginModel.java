package com.mkyong.common.controller.model;

public class IBLoginModel {
    private String userName;
    private String password;
    private String sslRefId;
    private double productPrice;

    public IBLoginModel(String userName, String password, String sslRefId, double productPrice) {
        this.userName = userName;
        this.password = password;
        this.sslRefId = sslRefId;
        this.productPrice = productPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSslRefId() {
        return sslRefId;
    }

    public void setSslRefId(String sslRefId) {
        this.sslRefId = sslRefId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
