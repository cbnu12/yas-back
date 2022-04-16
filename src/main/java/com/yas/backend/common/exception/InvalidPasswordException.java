package com.yas.backend.common.exception;

public class InvalidPasswordException extends YasBaseException {
    public InvalidPasswordException() {
        super(400, "패스워드가 일치하지 않습니다.");
    }
}
