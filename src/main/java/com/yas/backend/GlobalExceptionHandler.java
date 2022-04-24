package com.yas.backend;

import com.yas.backend.common.exception.ErrorResponse;
import com.yas.backend.common.exception.YasBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(YasBaseException.class)
    public ResponseEntity<ErrorResponse> handleYasException(YasBaseException exception) {
        log.error(exception.getClass().getName(), exception.getMessage());
        ErrorResponse response = exception.getErrorResponse();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getHttpStatusCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error(exception.getClass().getName(), exception.getMessage());
        String errorMessage = String.format("데이터 처리 중 오류가 발생하였습니다.%n%s", LocalDateTime.now());
        ErrorResponse response = new ErrorResponse(500, errorMessage);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getHttpStatusCode()));
    }
}
