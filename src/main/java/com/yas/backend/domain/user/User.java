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

    public boolean updatePassword(String password) {
        // ToDo 패스워드 복잡도 체크 필요
        boolean complexity = true;
        if (complexity) {
            this.password = password;
            this.lastPasswordUpdateAt = LocalDateTime.now();
        }
        return complexity;
    }
}
