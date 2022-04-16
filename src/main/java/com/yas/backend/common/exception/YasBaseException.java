package com.yas.backend.common.exception;

public abstract class YasBaseException extends RuntimeException{
    protected final int errorCode;

    protected YasBaseException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
