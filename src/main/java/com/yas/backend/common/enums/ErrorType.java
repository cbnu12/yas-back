package com.yas.backend.common.enums;

public enum ErrorType {
    NOT_FOUND_USER("User Not Found");

    private String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
