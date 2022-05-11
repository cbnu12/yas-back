package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.user.exchange.request.SignUpRequest;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.application.UserCreateService;
import com.yas.backend.domain.user.service.application.UserSearchService;
import com.yas.backend.domain.user.service.application.UserUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Users", description = "사용자 query API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserCommandController extends BaseController {
    private final UserCreateService userCreateService;
    private final UserUpdateService userUpdateService;
    private final UserSearchService userSearchService;

    private final UserMapper userMapper;

    @PostMapping("user")
    @Operation(summary = "계정 생성", description = "/api/SignUp EndPoint 동일 기능")
    public Long create(@RequestBody SignUpRequest request) {
        return this.signUp(request);
    }

    @PostMapping("signUp")
    @Operation(summary = "계정 생성", description = "/api/user EndPoint 동일 기능")
    public Long signUp(@RequestBody SignUpRequest request) {
        return this.userCreateService.signUp(request.toDto());
    }

}
