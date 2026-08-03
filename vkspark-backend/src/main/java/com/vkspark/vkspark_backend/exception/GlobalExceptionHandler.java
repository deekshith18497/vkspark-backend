package com.vkspark.vkspark_backend.exception;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ValidationErrorResponse> handleValidationException(

        MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult()

            .getFieldErrors()

            .forEach(error ->

                    errors.put(

                            error.getField(),

                            error.getDefaultMessage()

                    )

            );

    ValidationErrorResponse response =

            new ValidationErrorResponse(

                    false,

                    "Validation Failed",

                    HttpStatus.BAD_REQUEST.value(),

                    LocalDateTime.now(),

                    errors

            );

    return new ResponseEntity<>(

            response,

            HttpStatus.BAD_REQUEST

    );

}
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(response,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(
            RuntimeException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(response,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                "Something Went Wrong",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(response,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}