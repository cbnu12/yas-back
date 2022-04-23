package com.yas.backend.domain.user.data.exchange;

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
