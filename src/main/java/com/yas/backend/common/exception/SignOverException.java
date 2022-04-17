package com.yas.backend.common.exception;

public class SignOverException extends YasBaseException{

    public SignOverException() {
        super(403, "비밀번호를 5회이상 틀리셨습니다.");
    }
}
