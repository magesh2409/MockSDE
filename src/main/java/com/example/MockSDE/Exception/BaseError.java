package com.example.MockSDE.Exception;

import lombok.Data;

@Data
public class BaseError extends RuntimeException {
    private Integer code;

    public BaseError(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
