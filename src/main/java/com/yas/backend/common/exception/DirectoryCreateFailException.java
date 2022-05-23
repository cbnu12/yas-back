package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class DirectoryCreateFailException extends RuntimeException {
    public DirectoryCreateFailException() {
        super(ErrorType.DIRECTORY_CREATE_FAIL.getMessage());
    }
}
