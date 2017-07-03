package com.tks.exception;

import org.springframework.dao.DuplicateKeyException;

public class CustomException extends RuntimeException{

    String message;
    String statusCode;
    public CustomException(String message,String statusCode) {
       super(message);
        this.message=message;
        this.statusCode=statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
