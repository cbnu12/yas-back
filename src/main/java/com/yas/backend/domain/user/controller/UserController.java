package com.yas.backend.domain.user.controller;

import com.yas.backend.domain.user.data.dto.UserDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.data.response.UserResponse;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    @GetMapping("/getAllActiveUser")
    public List<UserResponse> findAllActiveUser() {
        return userService.findAllActiveUser().stream().map(userMapper::dtoToResponse).toList();
    }

    @GetMapping("/getActiveUserByEmail")
    public UserResponse findActiveUserByEmail(UserDto userDto) {
        return userService.findActiveUserByEmail(userDto.getEmail());
    }

    @PostMapping("/joinUser")
    public String joinUser(UserDto userDto) {
        return "";
    }


}
