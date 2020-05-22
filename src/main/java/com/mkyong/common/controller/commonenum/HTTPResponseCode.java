package com.mkyong.common.controller.commonenum;

public enum HTTPResponseCode {
    OPERATION_SUCCESSFULL(200),
    UNAUTHORIZED(401);

    private int code;

    HTTPResponseCode(int code) {
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
