package com.mjvdesafiofinal.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;


@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiException(ApiRequestException exception) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                exception.getMessage(),
                badRequest,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, badRequest);

    }

    @ExceptionHandler
    public ResponseEntity<Object> handleApiExceptionNotFound(NotFoundException exception) {

        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                exception.getMessage(),
                badRequest,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, badRequest);

    }
}
