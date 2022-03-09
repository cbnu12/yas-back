package com.yas.backend.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MemberResponse {
    private String email;
    private String nickname;
    private Integer birthYear;
    private Integer careerYear;
}
