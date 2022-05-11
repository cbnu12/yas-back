package com.yas.backend.domain.user.exchange.request;

public record UpdatePasswordRequest(
        String oldPassword,
        String newPassword
) {
}
