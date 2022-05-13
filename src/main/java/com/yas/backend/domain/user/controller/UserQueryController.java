package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.exchange.request.UserSearchRequest;
import com.yas.backend.domain.user.exchange.response.UserResponse;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.application.UserQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Users", description = "사용자 API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserQueryController extends BaseController {
    private final UserQueryService userQueryService;
    private final UserMapper userMapper;

    @GetMapping("users")
    @Operation(summary = "사용자 조회 (Email, Nickname)", description = "Email(Optional) : Equals<br/>AND<br/>Nickname(Optional) : Like")
    public List<UserResponse> findByPredicate(@ParameterObject UserSearchRequest request) {
        List<UserDto> results = this.userQueryService.findByPredicate(request);
        return results.stream().map(UserResponse::from).toList();
    }

    @GetMapping("user/{id}")
    @Operation(summary = "사용자 조회", description = "id를 기준으로 조회")
    public UserResponse findById(@PathVariable Long id) {
        UserDto result = this.userQueryService.findById(id);
        return UserResponse.from(result);
    }

}
