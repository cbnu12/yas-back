package com.yas.backend.domain.user.controller;

import com.yas.backend.domain.user.dto.SignInRequest;
import com.yas.backend.domain.user.dto.SignUpRequest;
import com.yas.backend.domain.user.dto.UpdatePasswordRequest;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.response.UserResponse;
import com.yas.backend.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@Tag(name = "Users [사용자]", description = "사용자 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/users")
    @Operation(summary = "사용자 전체 조회", description = "Email, Nickname 을 조회조건으로 받아 전체 대상자 조회")
    public List<UserResponse> findAll(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String nickname
    ) {
        Stream<UserDto> userDtoList = this.userService.findAll().stream();
        if (email != null)
            userDtoList = userDtoList.filter(arg -> arg.getEmail().equals(email));
        if (nickname != null)
            userDtoList = userDtoList.filter(arg -> arg.getNickname().equals(nickname));

        return userDtoList.map(this.userMapper::dtoToResponse).toList();
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "사용자 조회", description = "id가 파라미터")
    public UserResponse findById(@PathVariable Long id) {
        UserDto dto = this.userService.findById(id);
        return this.userMapper.dtoToResponse(dto);
    }

    @PostMapping("/users")
    @Operation(summary = "회원가입", description = "회원가입")
    public UserResponse createUser(SignUpRequest signUpRequest) {
        return this.signUp(signUpRequest);
    }

    @PostMapping("/users/signUp")
    @Operation(summary = "회원가입", description = "회원가입")
    public UserResponse signUp(SignUpRequest signUpRequest) {
        UserDto userDto = UserDto.builder()
                .birth(signUpRequest.getBirth())
                .careerStartAt(signUpRequest.getCareerStartAt())
                .email(signUpRequest.getEmail())
                .nickname(signUpRequest.getNickname())
                .password(signUpRequest.getPassword())
                .isActive(false)
                .showsBirth(signUpRequest.isShowsBirth())
                .build();

        return this.userMapper.dtoToResponse(this.userService.signUp(userDto));
    }

    @PostMapping("/users/signIn")
    @Operation(summary = "로그인", description = "로그인")
    public UserResponse login(SignInRequest signInRequest) {
        UserDto userDto = UserDto.builder()
                .email(signInRequest.getEmail())
                .password(signInRequest.getPassword())
                .build();
        return this.userMapper.dtoToResponse(this.userService.signIn(userDto));
    }

    @PutMapping("/users/{id}/password")
    @Operation(summary = "패스워드 변경", description = "이전 패스워드와 변경 패스워드 함께 입력 필요")
    public UserResponse updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordRequest request) {
        UserDto dto = this.userService.updatePassword(id, request.oldPassword(), request.newPassword());
        return this.userMapper.dtoToResponse(dto);
    }

    @DeleteMapping("/users/{id}")
    @Operation(summary = "회원 탈퇴", description = "Active 비활성화")
    public UserResponse signOut(@PathVariable Long id) {
        UserDto dto = this.userService.signOut(id);
        return this.userMapper.dtoToResponse(dto);
    }
}
