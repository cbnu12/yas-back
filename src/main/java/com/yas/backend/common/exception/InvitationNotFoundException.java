package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class InvitationNotFoundException extends RuntimeException {

    public InvitationNotFoundException() {
        super(ErrorType.NOT_FOUND_INVITATION.getMessage());
    }
}
