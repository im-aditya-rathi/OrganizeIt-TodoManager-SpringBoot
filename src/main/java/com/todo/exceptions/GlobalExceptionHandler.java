package com.todo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResouceNotFoundException.class)
    ResponseEntity<ExceptionResponse> resourceNotFoundException(ResouceNotFoundException ex) {

        logger.error("ERROR {}: ", ex.getMessage());
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setSuccess(false);
        exceptionResponse.setHttpStatus(HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}
