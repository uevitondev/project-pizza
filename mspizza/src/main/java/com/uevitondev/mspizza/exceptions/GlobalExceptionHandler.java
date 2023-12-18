package com.uevitondev.mspizza.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String ERRORS = "errors";

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ProblemDetail> resourceNotFound(ResourceNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "ResourceNotFoundException");
        problemDetail.setDetail("Resource error");
        problemDetail.setProperty(ERRORS, List.of(e.getLocalizedMessage()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<ProblemDetail> badCredentials(BadCredentialsException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, "BadCredentialsException");
        problemDetail.setDetail("Credentials error");
        problemDetail.setProperty(ERRORS, List.of(e.getLocalizedMessage()));

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(problemDetail);
    }

    @ExceptionHandler(AuthorizationException.class)
    protected ResponseEntity<ProblemDetail> noAuthorization(AuthorizationException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, "AuthorizationException");
        problemDetail.setDetail("Authorization error");
        problemDetail.setProperty(ERRORS, List.of(e.getLocalizedMessage()));

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(problemDetail);
    }


    @ExceptionHandler(DatabaseException.class)
    protected ResponseEntity<ProblemDetail> dataIntegrityViolation(DatabaseException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "DatabaseException");
        problemDetail.setDetail("Database error");
        problemDetail.setProperty(ERRORS, List.of(e.getLocalizedMessage()));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        super.handleMethodArgumentNotValid(e, headers, status, request);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, "MethodArgumentNotValidException");
        problemDetail.setDetail("Validation error");
        problemDetail.setProperty(ERRORS, e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList());
        problemDetail.setProperty("stackTrace", e.getStackTrace());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(problemDetail);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, "HttpMessageNotReadableException");
        problemDetail.setDetail("Validation error");
        problemDetail.setProperty(ERRORS, List.of(e.getLocalizedMessage()));
        problemDetail.setProperty("stackTrace", e.getStackTrace());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(problemDetail);
    }


}