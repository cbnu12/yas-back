package com.yas.backend.domain.user;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class User {
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

    public int getBirthYear() {
        return LocalDate.now().getYear() - this.birth.getYear();
    }

    public int getCareerYear() {
        return LocalDate.now().getYear() - this.careerStartAt.getYear();
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public void increasePasswordFailCount() {
        this.signInFailCount += 1;
    }

    public void updatePassword(String password) {
        this.password = password;
        this.lastPasswordUpdateAt = LocalDateTime.now();
    }
}
