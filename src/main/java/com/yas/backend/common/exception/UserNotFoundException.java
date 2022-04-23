package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super(ErrorType.NOT_FOUND_USER.getMessage());
    }
}
