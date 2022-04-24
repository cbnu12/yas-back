package com.yas.backend.domain.user.dto;

public record UpdatePasswordRequest(
        String oldPassword,
        String newPassword
) {

}
