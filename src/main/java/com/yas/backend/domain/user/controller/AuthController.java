package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.user.exchange.request.AuthRequest;
import com.yas.backend.domain.user.exchange.response.AuthResponse;
import com.yas.backend.domain.user.service.application.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AuthController extends BaseController {

    private final AuthService authService;

    @PostMapping("auth/validation")
    public AuthResponse isValidUser(@RequestBody AuthRequest request) {
        return new AuthResponse(authService.isValid(request.toDto()));
    }
}
