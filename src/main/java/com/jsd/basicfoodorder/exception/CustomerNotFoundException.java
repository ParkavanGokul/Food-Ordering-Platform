package com.jsd.basicfoodorder.exception;

public class CustomerNotFoundException extends RuntimeException {
    
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
