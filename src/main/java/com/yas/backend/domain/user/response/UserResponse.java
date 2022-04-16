package com.yas.backend.domain.user.response;

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
}
