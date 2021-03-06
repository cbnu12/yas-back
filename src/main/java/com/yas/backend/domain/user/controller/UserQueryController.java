package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.exchange.request.UserSearchRequest;
import com.yas.backend.domain.user.exchange.response.UserPageResponse;
import com.yas.backend.domain.user.exchange.response.UserResponse;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.application.UserQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Users", description = "사용자 API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserQueryController extends BaseController {
    private final UserQueryService userQueryService;
    private final UserMapper userMapper;

    @GetMapping("users")
    @Operation(summary = "사용자 조회", description = "조건 없는 경우 전체 조회, 조회조건 AND 조건으로 조회")
    public UserPageResponse findByPredicate(@ParameterObject final UserSearchRequest request, @ParameterObject final Pageable pageable) {
        Page<UserDto> results = this.userQueryService.findByPredicate(request, pageable);
        return UserPageResponse.from(results);
    }

    @GetMapping("user/{id}")
    @Operation(summary = "사용자 조회", description = "id를 기준으로 조회")
    public UserResponse findById(@PathVariable Long id) {
        UserDto result = this.userQueryService.findById(id);
        return UserResponse.from(result);
    }

}
