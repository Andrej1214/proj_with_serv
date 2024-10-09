package com.pavlov.first_rest.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
