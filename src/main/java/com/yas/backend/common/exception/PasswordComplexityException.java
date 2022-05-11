package com.yas.backend.common.exception;

public class PasswordComplexityException extends YasBaseException {
    public PasswordComplexityException() {
        super(400, "패스워드 복잡도를 만족하지 않습니다.");
    }
}
