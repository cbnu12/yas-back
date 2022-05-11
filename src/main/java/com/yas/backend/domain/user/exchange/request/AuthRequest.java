package com.yas.backend.domain.user.exchange.request;

import com.yas.backend.domain.user.dto.AuthDto;

public record AuthRequest(
        String email,
        String password
) {

    public AuthDto toDto() {
        return new AuthDto(email, password);
    }

}