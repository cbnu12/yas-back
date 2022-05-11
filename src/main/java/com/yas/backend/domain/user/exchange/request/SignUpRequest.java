package com.yas.backend.domain.user.exchange.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yas.backend.domain.user.dto.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record SignUpRequest (
    @Schema(description = "이메일", example = "example@naver.com")
    @JsonProperty("email")
    String email,

    @Schema(description = "비밀번호")
    @JsonProperty("password")
    String password,

    @Schema(description = "닉네임")
    @JsonProperty("nickname")
    String nickname,

    @Schema(description = "생일")
    @JsonProperty("birth")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    LocalDate birth,

    @Schema(description = "생일공개여부")
    @JsonProperty("showsBirth")
    boolean showsBirth,

    @Schema(description = "경력시작일")
    @JsonProperty("careerStartAt")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    LocalDate careerStartAt
) {
    public UserDto toDto() {
        return UserDto.builder()
                .email(this.email)
                .password(this.password)
                .nickname(this.nickname)
                .birth(this.birth)
                .showsBirth(this.showsBirth)
                .careerStartAt(this.careerStartAt)
                .build();
    }
}
