package com.yas.backend.domain.user.data.exchange;

import com.yas.backend.domain.user.data.dto.UserDto;

public record UserSearchRequest(
        String email
) {
    public UserDto toDto() {
        return UserDto.builder()
                .email(this.email)
                .build();
    }

}
