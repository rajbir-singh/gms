package com.gms.error;


import com.gms.exception.BindingErrorException;
import com.gms.exception.ResourceNotFoundException;
import com.gms.utils.ValidationUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    public RestResponseEntityExceptionHandler() {
        super();
    }

    private String preProcessExceptionAndGetErrorMessage(Exception e) {
        //TODO : print stackTrace only in debug profile
        e.printStackTrace();
        return e.getMessage();
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // 404

    @ExceptionHandler(value = {ResourceNotFoundException.class, ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(final ResourceNotFoundException ex, final WebRequest request) {
        final String errorMessage = preProcessExceptionAndGetErrorMessage(ex);
        ApiError apiError = ApiError.Builder.apiError()
                .withStatus(HttpStatus.NOT_FOUND)
                .withTimestamp(LocalDateTime.now())
                .withMessage(errorMessage)
                .withDebugMessage(ex.getLocalizedMessage())
                .withSubErrors(Collections.emptyList())
                .build();

        return buildResponseEntity(apiError);
    }

    //IllegalArgs
    @ExceptionHandler(value = {BindingErrorException.class})
    protected ResponseEntity<Object> handleBindingException(final BindingErrorException ex, final WebRequest request) {
        final String errorMessage = preProcessExceptionAndGetErrorMessage(ex);
        BindingResult bindingResult = ex.getBindingResult();
        ApiError apiError = ApiError.Builder.apiError()
                .withStatus(HttpStatus.BAD_REQUEST)
                .withTimestamp(LocalDateTime.now())
                .withMessage(errorMessage)
                .withDebugMessage(ex.getLocalizedMessage())
                .withSubErrors(ValidationUtils.fromBindingErrors(bindingResult))
                .build();

        return buildResponseEntity(apiError);
    }

    // API

    // 400

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleBadRequest(final ConstraintViolationException ex, final WebRequest request) {
        final String bodyOfResponse = preProcessExceptionAndGetErrorMessage(ex);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex, final WebRequest request) {
        final String bodyOfResponse = preProcessExceptionAndGetErrorMessage(ex);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final String bodyOfResponse = preProcessExceptionAndGetErrorMessage(ex);
        // ex.getCause() instanceof JsonMappingException, JsonParseException // for additional information later on
        return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final String bodyOfResponse = preProcessExceptionAndGetErrorMessage(ex);
        return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    // 409

    @ExceptionHandler({InvalidDataAccessApiUsageException.class, DataAccessException.class})
    protected ResponseEntity<Object> handleConflict(final RuntimeException ex, final WebRequest request) {
        final String bodyOfResponse = preProcessExceptionAndGetErrorMessage(ex);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    // 412

    // 500

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class})
    /*500*/ public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
        logger.error("500 Status Code", ex);
        final String bodyOfResponse = preProcessExceptionAndGetErrorMessage(ex);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}

