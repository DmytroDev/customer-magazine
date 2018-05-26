package com.example.magazine.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;

@Getter
@JsonFormat(shape = OBJECT)
public enum GeneralErrorCode implements ApplicationError {

    GENERAL_ERROR("GENERAL_ERROR", "Internal server error.");

    private String errorCode;
    private String message;

    GeneralErrorCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
