package com.yas.backend.domain.member;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDto {
    private String email;
    private String nickname;
    private Integer birthYear;
    private Integer careerYear;
}
