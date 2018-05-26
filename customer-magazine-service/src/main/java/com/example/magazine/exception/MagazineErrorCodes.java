package com.example.magazine.exception;

import com.example.magazine.exception.autentification.AuthError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagazineErrorCodes {

    private static List<ApplicationError> errors = new ArrayList<ApplicationError>() {
        {
            {
                addAll(Arrays.asList(GeneralErrorCode.values()));
                addAll(Arrays.asList(AuthError.values()));
            }
        }
    };

    public static List<ApplicationError> getErrors() {
        return errors;
    }
}
