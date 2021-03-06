package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.user.exchange.request.AuthRequest;
import com.yas.backend.domain.user.exchange.response.AuthResponse;
import com.yas.backend.domain.user.service.application.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth", description = "인증 Api")
@RestController
@RequiredArgsConstructor
public class AuthController extends BaseController {

    private final AuthService authService;

    @PostMapping("auth/validation")
    @Operation(summary = "로그인 인증", description = "로그인")
    public AuthResponse isValidUser(@RequestBody AuthRequest request) {
        return new AuthResponse(authService.isValid(request.toDto()));
    }
}
