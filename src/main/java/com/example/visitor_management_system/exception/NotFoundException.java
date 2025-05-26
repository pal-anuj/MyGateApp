package com.example.visitor_management_system.exception;

import java.lang.reflect.Constructor;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
