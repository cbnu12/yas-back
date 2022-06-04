package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class InvitationAlreadyExistException extends RuntimeException {
    public InvitationAlreadyExistException() {
        super(ErrorType.INVITATION_ALREADY_EXIST.getMessage());
    }
}
