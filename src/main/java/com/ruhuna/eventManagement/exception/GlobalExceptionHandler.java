package com.ruhuna.eventManagement.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ruhuna.eventManagement.dto.ApiResponse;
import com.ruhuna.eventManagement.dto.ResponseUtil;
import com.ruhuna.eventManagement.exception.custom.ResourceNotFoundException;
import com.ruhuna.eventManagement.exception.custom.UserNotFoundException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ================= Common Builder =================
    private ResponseEntity<ApiResponse<Object>> buildResponse(
            String message,
            HttpStatus status
    ) {

        ApiResponse<Object> response = ResponseUtil.error(
                message,
                null
        );

        return ResponseEntity.status(status).body(response);
    }

    private String getDefaultMessages(MethodArgumentNotValidException ex) {
        if (ex == null) return "Validation failed";

        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));
    }

    private String getConstraintViolationMessages(ConstraintViolationException ex) {
        if (ex == null) return "Validation failed";

        return ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining("; "));
    }

    // ================= Custom Exceptions =================

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleUserNotFound(UserNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // ================= Resource Not Found =================
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // ================= Validation Exceptions =================
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleBodyValidation(MethodArgumentNotValidException ex) {
        String message = getDefaultMessages(ex);
        return buildResponse(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<Object>> handleParamValidation(ConstraintViolationException ex) {
        String message = getConstraintViolationMessages(ex);
        return buildResponse(message, HttpStatus.BAD_REQUEST);
    }

    // ================= Missing Parameters =================
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse<Object>> handleMissingParams(MissingServletRequestParameterException ex) {
        return buildResponse(
                "Missing request parameter: " + ex.getParameterName(),
                HttpStatus.BAD_REQUEST
        );
    }

    // ================= Missing Path Variables =================
    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ApiResponse<Object>> handleMissingPathVariable(MissingPathVariableException ex) {
        return buildResponse(
                "Missing path variable: " + ex.getVariableName(),
                HttpStatus.BAD_REQUEST
        );
    }

    // ================= Fallback =================
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleAllExceptions(Exception ex) {
        return buildResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}