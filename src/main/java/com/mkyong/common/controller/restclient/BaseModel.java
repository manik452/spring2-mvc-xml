package com.mkyong.common.controller.restclient;

import java.util.List;

public class BaseModel {
    private int responseCode;
    private List<String> message;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
