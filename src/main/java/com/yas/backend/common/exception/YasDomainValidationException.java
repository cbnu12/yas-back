package com.yas.backend.common.exception;

public class YasDomainValidationException extends RuntimeException {
    public YasDomainValidationException(String message) {
        super(message);
    }
}
