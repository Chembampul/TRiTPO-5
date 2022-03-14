package com.example.lab1_cpp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionInfo {

    @JsonProperty
    private String message;

    @JsonProperty
    private int errorCode;

    public ExceptionInfo(String message, int errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }

}
