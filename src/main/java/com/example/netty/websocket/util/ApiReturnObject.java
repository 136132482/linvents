package com.example.netty.websocket.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiReturnObject implements Serializable {

    private static final long serialVersionUID = 1L;

    String errorCode="00";
    Object errorMessage;
    Object returnObject;


    public ApiReturnObject(String errorCode, Object errorMessage, Object returnObject) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.returnObject = returnObject;
    }



}
