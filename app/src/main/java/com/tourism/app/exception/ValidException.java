package com.tourism.app.exception;

public class ValidException extends Exception {

    private String message;

    public ValidException(String message) {
    }

    public String getMessage() {
        return message;
    }
}
