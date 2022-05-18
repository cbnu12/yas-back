package com.yas.backend.domain.user.exchange.request;

import com.yas.backend.domain.user.dto.AuthDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class AuthRequest {
    @Schema(description = "이메일", example = "test@yas.com")
    String email;
    @Schema(description = "패스워드", example = "password")
    String password;

    public AuthDto toDto() {
        return new AuthDto(email, password);
    }
}