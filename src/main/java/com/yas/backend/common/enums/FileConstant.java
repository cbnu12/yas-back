package com.yas.backend.common.enums;

/**
 * @see FileConstant <a href="https://preamtree.tistory.com/158">Set Config Value To Enum</a>
 */
public enum FileConstant {

    DEFAULT_PROFILE_IMAGE("http://localhost:8080/DefaultProfileImageUUID");

    private final String message;

    FileConstant(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
