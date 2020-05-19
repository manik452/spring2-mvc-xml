package com.mkyong.common.controller.model;

public class LoginModel {
    private String merchantKey;
    private String merchantPassword;
    private String sslRefId;
    private double productPrice;
    private String merchantName;

    public LoginModel() {
    }

    public LoginModel(String merchantKey, String merchantPassword, String sslRefId, double productPrice, String merchantName) {
        this.merchantKey = merchantKey;
        this.merchantPassword = merchantPassword;
        this.sslRefId = sslRefId;
        this.productPrice = productPrice;
        this.merchantName = merchantName;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
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

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
