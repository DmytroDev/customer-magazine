package com.example.magazine.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;

@Getter
@JsonFormat(shape = OBJECT)
public class CustomerException extends ApplicationException {

    private final ApplicationError error;
    private final HttpStatus status;

    public CustomerException(ApplicationError error, HttpStatus status) {
        super(error.getMessage());
        this.error = error;
        this.status = status;
    }

    public CustomerException(String message, ApplicationError error, HttpStatus status) {
        super(message);
        this.error = error;
        this.status = status;
    }
}
