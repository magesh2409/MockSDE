package com.example.MockSDE.Dto;

import com.example.MockSDE.Exception.ErrorCodes;
import lombok.Data;

@Data
public class ErrorResponse {
    private int code;
    private String message;

    public ErrorResponse(int code, String message){
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(){
        this.code = ErrorCodes.UN_HANDLED_ERROR;
        this.message = "Unhandled error occurred";
    }

    public ErrorResponse(String message){
        this.code = ErrorCodes.UN_HANDLED_ERROR;
        this.message = message;
    }
}
