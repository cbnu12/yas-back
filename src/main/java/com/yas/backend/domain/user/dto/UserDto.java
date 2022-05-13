package com.yas.backend.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String profileImage;
    private LocalDate birth;
    private boolean showsBirth;
    private LocalDate careerStartAt;
    private boolean isActive;
    private LocalDateTime lastPasswordUpdateAt;
    private Integer signInFailCount;

    private Integer birthYears;
    private Integer careerYears;
}
