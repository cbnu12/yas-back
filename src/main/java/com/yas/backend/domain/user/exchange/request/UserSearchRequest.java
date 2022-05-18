package com.yas.backend.domain.user.exchange.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserSearchRequest {
    @Schema(description = "이메일", example = "test@yas.com")
    String email;
    @Schema(description = "닉네임", example = "강성조")
    String nickname;
}