package com.yas.backend.domain.user.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {
    private String email;
    private String nickname;
    private Integer years;
    private Integer careerYear;
}
