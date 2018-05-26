package com.example.magazine.exception.autentification;

import com.example.magazine.exception.ApplicationError;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;

@Getter
@JsonFormat(shape = OBJECT)
public enum AuthError implements ApplicationError {

    AUTHENTICATION_ERROR("AUTHENTICATION_ERROR", "There is some problem during authentication."),
    FORBIDDEN_ERROR("FORBIDDEN_ERROR", "Access is denied."),
    LOGIN_INVALID_USERNAME("LOGIN_INVALID_USERNAME", "Credentials are wrong or account is blocked. Please contact support for help.");

    private String errorCode;
    private String message;

    AuthError(String errorCode, String messagee) {
        this.errorCode = errorCode;
        this.message = messagee;
    }

}
