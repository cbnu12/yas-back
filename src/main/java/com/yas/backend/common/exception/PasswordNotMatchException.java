package com.yas.backend.common.exception;

public class PasswordNotMatchException extends YasBaseException {

    public PasswordNotMatchException() {
        super(403, "패스워드가 일치하지 않습니다.");
    }
}
