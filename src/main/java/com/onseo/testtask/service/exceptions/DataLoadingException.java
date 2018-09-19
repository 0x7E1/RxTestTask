package com.onseo.testtask.service.exceptions;

public class DataLoadingException extends RuntimeException {
    public DataLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
