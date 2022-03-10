package com.yas.backend.domain.member.data;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private String email;
    private String password;
    private String nickname;
    private Integer birthYear;
    private Boolean showBirthYear;
    private Integer careerYear;
}
