package com.yas.backend.domain.member.data;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class Member {
    private String email;
    private String password;
    private String nickname;
    private LocalDate birth;
    private Boolean showsBirth;
    private LocalDate careerStartAt;
}
