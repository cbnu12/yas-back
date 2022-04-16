package com.yas.backend.domain.user.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yas.backend.common.entity.JoinEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class SignUpRequest {

    @Schema(description = "이메일", example = "example@naver.com")
    @JsonProperty("email")
    private String email;

    @Schema(description = "비밀번호")
    @JsonProperty("password")
    private String password;

    @Schema(description = "닉네임")
    @JsonProperty("nickname")
    private String nickname;

    @Schema(description = "생일")
    @JsonProperty("birth")
    @JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private LocalDate birth;

    @Schema(description = "생일공개여부")
    @JsonProperty("showsBirth")
    private boolean showsBirth;

    @Schema(description = "경력시작일")
    @JsonProperty("careerStartAt")
    @JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private LocalDate careerStartAt;

    @Schema(description = "활동여부")
    @JsonProperty("isActive")
    private boolean isActive;

    @Schema(description = "아이디생성자")
    @JsonProperty("createdBy")
    private String createdBy;

    @Schema(description = "아이디생성일")
    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;


}
