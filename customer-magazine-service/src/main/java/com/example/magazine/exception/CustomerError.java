package com.example.magazine.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;

@Getter
@JsonFormat(shape = OBJECT)
public enum CustomerError implements ApplicationError {

    CUSTOMER_NOT_FOUND("CUSTOMER_NOT_FOUND", "The customer is not found"),
    CUSTOMER_GENERAL_ERROR("CUSTOMER_GENERAL_ERROR", "Customer general error");

    private String errorCode;
    private String message;

    CustomerError(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

}
