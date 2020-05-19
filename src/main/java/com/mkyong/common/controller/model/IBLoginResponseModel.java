package com.mkyong.common.controller.model;

public class IBLoginResponseModel {
    private String message;
    private int responseCode;

    public IBLoginResponseModel() {
    }

    public IBLoginResponseModel(String message, int responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
