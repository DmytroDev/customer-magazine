package com.example.magazine.controller;

import com.example.magazine.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.example.magazine.exception.autentification.AuthError.FORBIDDEN_ERROR;
import static com.example.magazine.util.ResponseBuildUtils.buildErrorDataWithLocalizationKeys;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class ExceptionInterceptor {

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseEntity<Map<String, List<Map<String, String>>>> handleApplicationException(final ApplicationException exception) {
        if (INTERNAL_SERVER_ERROR == exception.getStatus()) {
            log.error("ApplicationException intercepted: {} : {}.", exception.getError().getErrorCode(), exception.getMessage(), exception);
        } else {
            log.warn("ApplicationException intercepted: {} : {}.", exception.getError().getErrorCode(), exception.getMessage());
        }
        return new ResponseEntity<>(buildErrorDataWithLocalizationKeys(exception.getError()), exception.getStatus());
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(FORBIDDEN)
    public Map handleAccessDeniedException(AccessDeniedException exception) {
        log.warn("AccessDeniedException intercepted: {}", exception.getMessage());
        return Collections.singletonMap(FORBIDDEN_ERROR, FORBIDDEN_ERROR.getMessage());
    }

}
