package com.yas.backend.common.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final int httpStatusCode;
    private final String message;

    public ErrorResponse(int httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }
}
