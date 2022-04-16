package com.yas.backend.domain.user.data;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class User {
    private String email;
    private String password;
    private String nickname;
    private LocalDate birth;
    private Boolean showsBirth;
    private LocalDate careerStartAt;
}
