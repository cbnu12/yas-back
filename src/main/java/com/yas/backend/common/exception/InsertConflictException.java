package com.yas.backend.common.exception;

public class InsertConflictException extends YasBaseException {
    public InsertConflictException() {
        super(401, "Data Already Exists");
    }
}
