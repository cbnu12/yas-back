package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.user.data.dto.UserDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.data.response.LoginResponse;
import com.yas.backend.domain.user.data.response.UserResponse;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("users")
    public List<UserResponse> findAllActiveUser() {
        return userService.findAllActiveUser().stream().map(userMapper::dtoToResponse).toList();
    }

    @GetMapping("user")
    public UserResponse findActiveUserByEmail(@Param("email") String email) {
        return userMapper.dtoToResponse(userService.findUserByEmail(email));
    }

    @PostMapping("/sign-up")
    public UserResponse joinUser(UserDto userDto) {
        return userMapper.dtoToResponse(userService.joinUser(userDto));
    }

    @PostMapping("/sign-in")
    public LoginResponse login(UserDto userDto) {
        return userService.login(userDto);
    }

}
