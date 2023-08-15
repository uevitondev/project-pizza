package com.uevitondev.mspizza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    ProblemDetail resourceNotFound(ResourceNotFoundException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    ProblemDetail resourceNotFound(BadCredentialsException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
    }
}
