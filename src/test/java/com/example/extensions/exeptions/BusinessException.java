package com.example.extensions.exeptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}