package com.example.MockSDE.Exception;

import com.example.MockSDE.Dto.ErrorResponse;
import com.example.MockSDE.Repository.LoggerRepository;
import com.example.MockSDE.Repository.PlatformRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final LoggerRepository loggerRepository =  new LoggerRepository();
    private final Logger logger = loggerRepository.logger;

    @ExceptionHandler(BaseError.class)
    public ResponseEntity<ErrorResponse> handleBaseError(BaseError ex) {
        String errorMsg = ex.getMessage();
        logger.error(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), errorMsg);
        return ResponseEntity.status(ex.getCode()).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexceptedException(Exception ex) {
        String errorMsg = ex.getMessage();
//        String errorMsg = "An unknown error occurred";
        logger.error(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(errorMsg);
        return ResponseEntity.status(errorResponse.getCode()).body(errorResponse);
    }
}
