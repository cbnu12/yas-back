package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class FileCreateFailException extends RuntimeException {
    public FileCreateFailException() {
        super(ErrorType.FILE_CREATE_FAIL.getMessage());
    }
}
