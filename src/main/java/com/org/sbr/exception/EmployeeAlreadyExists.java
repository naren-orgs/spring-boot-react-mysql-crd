package com.org.sbr.exception;

public class EmployeeAlreadyExists extends RuntimeException {
    public EmployeeAlreadyExists(String message) {
        super(message);
    }
}
