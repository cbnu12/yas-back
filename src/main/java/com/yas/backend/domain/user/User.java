package com.yas.backend.domain.user;

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

    public int getBirthYear() {
        return LocalDate.now().getYear() - this.birth.getYear();
    }

    public int getCareerYear() {
        return LocalDate.now().getYear() - this.careerStartAt.getYear();
    }
}
