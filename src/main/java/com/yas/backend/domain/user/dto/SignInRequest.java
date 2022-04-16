package com.yas.backend.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class SignInRequest {

    @Schema(description = "이메일", example = "example@naver.com")
    @JsonProperty("email")
    private String email;

    @Schema(description = "비밀번호")
    @JsonProperty("password")
    private String password;
}
