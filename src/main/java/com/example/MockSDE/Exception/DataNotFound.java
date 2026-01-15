package com.example.MockSDE.Exception;


public class DataNotFound extends BaseError {
    public DataNotFound(String message) {
        super(message, ErrorCodes.DATA_NOT_FOUND);
    }
}
