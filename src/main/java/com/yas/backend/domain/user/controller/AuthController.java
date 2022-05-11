package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.user.exchange.request.AuthRequest;
import com.yas.backend.domain.user.exchange.response.AuthResponse;
import com.yas.backend.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController extends BaseController {

    private final AuthService authService;

    @GetMapping("validation")
    public AuthResponse isValidUser(AuthRequest request) {
        return new AuthResponse(authService.isValid(request.toDto()));
    }
}
