package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class JoinNotFoundException extends RuntimeException{

    public JoinNotFoundException() {
        super(ErrorType.NOT_FOUND_JOIN.getMessage());
    }
}
