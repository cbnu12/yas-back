package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.data.exchange.UserResponse;
import com.yas.backend.domain.user.data.exchange.UserSearchRequest;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserSearchService userSearchService;
    private final UserMapper userMapper;

    @GetMapping("users")
    public List<UserResponse> findAll(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String nickname,
            @RequestParam(required = false) Boolean isActive
    ) {
        return userSearchService.findAll(email, nickname, isActive).stream().map(userMapper::dtoToResponse).toList();
    }

    @GetMapping("user")
    public UserResponse findUserByEmail(UserSearchRequest request) {
        try {
            return userMapper.dtoToResponse(userSearchService.findUserByEmail(request.toDto()));
        } catch (UserNotFoundException e) {
            log.info(e.getMessage());
            return UserResponse.empty();
        }
    }
}
