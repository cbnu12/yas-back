package com.yas.backend.domain.user.exchange.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yas.backend.domain.user.dto.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
public class SignUpRequest {
    @Schema(description = "이메일", example = "test@yas.com")
    String email;
    @Schema(description = "비밀번호")
    String password;
    @Schema(description = "닉네임")
    String nickname;
    @Schema(description = "생일")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    LocalDate birth;
    @Schema(description = "생일공개여부")
    boolean showsBirth;
    @Schema(description = "경력시작일")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    LocalDate careerStartAt;

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
