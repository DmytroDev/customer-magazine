package com.example.magazine.exception;

import org.springframework.http.HttpStatus;

public abstract class ApplicationException extends RuntimeException {

    public abstract HttpStatus getStatus();

    public abstract ApplicationError getError();

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
