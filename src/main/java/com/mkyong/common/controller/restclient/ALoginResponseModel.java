package com.mkyong.common.controller.restclient;

public class ALoginResponseModel extends BaseModel {
    private AccessToken data;

    public AccessToken getData() {
        return data;
    }

    public void setData(AccessToken data) {
        this.data = data;
    }
}
