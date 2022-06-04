package com.yas.backend.common.exception;

public class PasswordFailOverException extends YasBaseException {

    public PasswordFailOverException() {
        super(403, "패스워드를 5회이상 틀리셨습니다.");
    }
}
