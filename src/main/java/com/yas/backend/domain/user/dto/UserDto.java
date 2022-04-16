package com.yas.backend.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class UserDto {
    private String email;
    private String nickname;
    private Integer years;
    private Integer careerYear;
    private String password;
    private LocalDate birth;
    private boolean showsBirth;
    private LocalDate careerStartAt;
    private boolean isActive;
    private LocalDateTime lastPasswordUpdateAt;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
