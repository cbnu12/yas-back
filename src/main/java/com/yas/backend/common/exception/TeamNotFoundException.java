package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class TeamNotFoundException extends YasDomainValidationException {

    public TeamNotFoundException() {
        super(ErrorType.NOT_FOUND_TEAM.getMessage());
    }
}
