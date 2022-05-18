package com.yas.backend.domain.user.exchange.response;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class AuthResponse {
    boolean isValid;

    public AuthResponse(boolean isValid) {
        this.isValid = isValid;
    }
}
