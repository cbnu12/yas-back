package com.yas.backend.common.exception;

import com.yas.backend.common.enums.ErrorType;

public class FileReadFailException extends RuntimeException {
    public FileReadFailException() {
        super(ErrorType.FILE_READ_FAIL.getMessage());
    }

}