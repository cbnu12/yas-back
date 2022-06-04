package com.yas.backend.common.enums;

public enum ErrorType {
    INSERT_CONFLICT("Data Already Exists"),
    NOT_FOUND_USER("User Not Found"),
    NOT_FOUND_TEAM("Team Not Found"),
    NOT_FOUND_JOIN("Join Not Found"),
    JOIN_ALREADY_EXIST("Join Already Exist"),
    DIRECTORY_CREATE_FAIL("Directory Create Fail"),
    FILE_CREATE_FAIL("File Create Fail"),
    FILE_READ_FAIL("File Read Fail"),
    NOT_FOUND_INVITATION("Invitation Not Found"),
    INVITATION_ALREADY_EXIST("Invitation Already Exist");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
