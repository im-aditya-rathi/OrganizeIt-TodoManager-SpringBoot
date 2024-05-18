package com.todo.exceptions;

import org.springframework.http.HttpStatus;

public class ResouceNotFoundException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public ResouceNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ResouceNotFoundException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
