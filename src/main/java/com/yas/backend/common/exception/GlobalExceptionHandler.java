package com.yas.backend.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(YasBaseException.class)
    public ResponseEntity<ErrorResponse> handleYasException(YasBaseException exception) {
        log.error(exception.getClass().getName(), exception.getMessage());
        ErrorResponse response = exception.getErrorResponse();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getHttpStatusCode()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleException(ValidationException exception) {
        log.info(exception.getClass().getName(), exception.getMessage());
        log.info(Arrays.toString(exception.getStackTrace()));
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getHttpStatusCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error(exception.getClass().getName(), exception.getMessage());
        String errorMessage = String.format("데이터 처리 중 오류가 발생하였습니다.%n%s", LocalDateTime.now());
        ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getHttpStatusCode()));
    }

}
