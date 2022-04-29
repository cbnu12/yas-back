package com.yas.backend.domain.user.data.exchange;

import com.yas.backend.domain.user.data.dto.AuthDto;

public record AuthRequest(
        String email,
        String password
) {

    public AuthDto toDto() {
        return new AuthDto(email, password);
    }

}