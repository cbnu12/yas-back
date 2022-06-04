package com.yas.backend.common.exception;

public abstract class YasBaseException extends RuntimeException {
    protected final ErrorResponse errorResponse;

    protected YasBaseException(int statusCode, String message) {
        super(message);
        this.errorResponse = new ErrorResponse(statusCode, message);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
