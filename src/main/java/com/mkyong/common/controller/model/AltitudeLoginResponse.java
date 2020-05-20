package com.mkyong.common.controller.model;

public class AltitudeLoginResponse extends BaseModel {
   AltitudeResponseToken data;

    public AltitudeResponseToken getData() {
        return data;
    }

    public void setData(AltitudeResponseToken data) {
        this.data = data;
    }
}
