package com.jsd.basicfoodorder.exception;

public class AdminNotFoundException extends RuntimeException {
    
    public AdminNotFoundException(String message) {
        super(message);
    }
}
