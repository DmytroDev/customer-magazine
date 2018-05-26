package com.example.magazine.util;

import com.example.magazine.exception.ApplicationError;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseBuildUtils {

    private static final String LOCALIZATION_KEY = "localizationKey";
    private static final String MESSAGE = "message";
    private static final String GENERAL_VALIDATION_ERRORS = "generalValidationErrors";

    public static Map<String, List<Map<String, String>>> buildErrorDataWithLocalizationKeys(ApplicationError error) {
        Map<String, List<Map<String, String>>> result = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        errors.put(LOCALIZATION_KEY, error.getErrorCode());
        errors.put(MESSAGE, error.getMessage());

        result.put(GENERAL_VALIDATION_ERRORS, Collections.singletonList(errors));
        return result;
    }

}
