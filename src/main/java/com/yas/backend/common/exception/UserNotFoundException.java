package com.yas.backend.common.exception;

public class UserNotFoundException extends YasBaseException {
    public UserNotFoundException() {
        super(404, "사용자가 조회되지 않습니다.");
    }
}
