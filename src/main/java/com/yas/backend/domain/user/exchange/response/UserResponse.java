package com.yas.backend.domain.user.exchange.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponse {
    private String email;
    private String nickname;
    private Integer birthYear;
    private Integer careerYear;

    public static UserResponse empty() {
        return UserResponse.builder().build();
    }
}
