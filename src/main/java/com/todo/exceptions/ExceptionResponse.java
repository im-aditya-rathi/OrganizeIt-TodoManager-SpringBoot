package com.todo.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

    private String message;
    private boolean success;
    private HttpStatus httpStatus;

    public ExceptionResponse(String message, boolean success, HttpStatus httpStatus) {
        this.message = message;
        this.success = success;
        this.httpStatus = httpStatus;
    }

    public ExceptionResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
