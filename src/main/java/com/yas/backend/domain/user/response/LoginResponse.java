package com.yas.backend.domain.user.response;

import com.yas.backend.common.enums.LoginResponseCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private LoginResponseCode loginResponseCode;
}
