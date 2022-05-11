package com.yas.backend.domain.user.exchange.request;

import com.yas.backend.domain.user.dto.UserDto;

public record UserSearchRequest(
        String email
) {
    public UserDto toDto() {
        return UserDto.builder()
                .email(this.email)
                .build();
    }

}
