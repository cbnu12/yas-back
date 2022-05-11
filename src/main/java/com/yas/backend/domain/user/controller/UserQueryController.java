package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.exchange.request.UserSearchRequest;
import com.yas.backend.domain.user.exchange.response.UserResponse;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.application.UserSearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Users", description = "사용자 query API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserQueryController extends BaseController {
    private final UserSearchService userSearchService;
    private final UserMapper userMapper;

    @GetMapping("users")
    public List<UserResponse> findAllActiveUser() {
        return userSearchService.findAllActiveUser()
                .stream().map(userMapper::dtoToResponse).toList();
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
