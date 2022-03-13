package com.yas.backend.domain.member.data.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberVo {
    private String email;
    private String password;
}
