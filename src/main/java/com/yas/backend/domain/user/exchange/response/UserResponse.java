package com.yas.backend.domain.user.exchange.response;

import com.yas.backend.common.enums.FileConstant;
import com.yas.backend.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {
    private String email;
    private String nickname;
    private String profileImage;
    private Integer birthYear;
    private Integer careerYear;

    public static UserResponse empty() {
        return UserResponse.builder().build();
    }

    public static UserResponse from(UserDto dto) {
        return UserResponse.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .profileImage(dto.getProfileImage().isEmpty() ? FileConstant.DEFAULT_PROFILE_IMAGE.toString() : dto.getProfileImage())
                .birthYear(dto.isShowsBirth() ? dto.getBirthYears() : null)
                .careerYear(dto.getCareerYears())
                .build();
    }
}
