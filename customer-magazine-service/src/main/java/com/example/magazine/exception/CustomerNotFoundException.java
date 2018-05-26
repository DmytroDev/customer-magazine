package com.example.magazine.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import static com.example.magazine.exception.CustomerError.CUSTOMER_NOT_FOUND;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerNotFoundException extends CustomerException {

    public CustomerNotFoundException(String message) {
        super(message, CUSTOMER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
