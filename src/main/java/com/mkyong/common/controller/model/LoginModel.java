package com.mkyong.common.controller.model;

public class LoginModel {
    private String merchantKey;
    private String sslRefId;
    private String productPrice;
    private String merchantName;

    public LoginModel() {
    }

    public LoginModel(String merchantKey,  String sslRefId, String productPrice, String merchantName) {
        this.merchantKey = merchantKey;
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

    public String getSslRefId() {
        return sslRefId;
    }

    public void setSslRefId(String sslRefId) {
        this.sslRefId = sslRefId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
