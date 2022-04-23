package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.user.data.dto.UserDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.data.response.LoginResponse;
import com.yas.backend.domain.user.data.response.UserResponse;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController extends BaseController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/sign-up")
    public UserResponse signUp(UserDto userDto) {
        return userMapper.dtoToResponse(userService.joinUser(userDto));
    }

    @PostMapping("/sign-in")
    public LoginResponse signIn(UserDto userDto) {
        return userService.login(userDto);
    }
}
