package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException() {
        super(ErrorType.NOT_FOUND_TEAM.getMessage());
    }
}
