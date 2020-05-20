package com.mkyong.common.controller.model;

import java.util.List;

public class BaseModel {
    private List<String> messages;
    private int responseCode;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
