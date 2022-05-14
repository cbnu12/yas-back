package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class JoinAlreadyExistException extends RuntimeException{
    public JoinAlreadyExistException() {
        super(ErrorType.JOIN_ALREADY_EXIST.getMessage());
    }
}
