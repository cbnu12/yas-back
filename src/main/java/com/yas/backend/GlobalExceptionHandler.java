package com.yas.backend;

import com.yas.backend.common.exception.ErrorResponse;
import com.yas.backend.common.exception.YasBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
        List<String> stackTraceElements = Arrays.stream(exception.getStackTrace()).map(StackTraceElement::toString).toList();
        log.error(String.join("\n", stackTraceElements));

        String errorMessage = String.format("데이터 처리 중 오류가 발생하였습니다.%n%s", LocalDateTime.now());
        ErrorResponse response = new ErrorResponse(500, errorMessage);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getHttpStatusCode()));
    }
}
