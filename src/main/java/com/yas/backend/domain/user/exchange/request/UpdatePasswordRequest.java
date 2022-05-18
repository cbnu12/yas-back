package com.yas.backend.domain.user.exchange.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UpdatePasswordRequest {
    @Schema(description = "구 패스워드", example = "password")
    String oldPassword;
    @Schema(description = "신 패스워드", example = "password")
    String newPassword;
}