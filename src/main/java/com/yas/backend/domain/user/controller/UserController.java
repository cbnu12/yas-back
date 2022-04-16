package com.yas.backend.domain.user.controller;

import com.yas.backend.domain.user.dto.SignInRequest;
import com.yas.backend.domain.user.dto.SignUpRequest;
import com.yas.backend.domain.user.dto.UpdatePasswordRequest;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.response.UserResponse;
import com.yas.backend.domain.user.data.dto.SignInRequest;
import com.yas.backend.domain.user.data.dto.SignUpRequest;
import com.yas.backend.domain.user.data.dto.UserDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.data.response.UserResponse;
import com.yas.backend.domain.user.service.UserService;
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
    public List<UserResponse> findAll(@RequestParam(required = false) String email,
                                      @RequestParam(required = false) String nickname) {
        Stream<UserDto> userDtoList = this.userService.findAll().stream();
        if (email != null)
            userDtoList = userDtoList.filter(arg -> arg.getEmail().equals(email));
        if (nickname != null)
            userDtoList = userDtoList.filter(arg -> arg.getNickname().equals(nickname));

        return userDtoList.map(this.userMapper::dtoToResponse).toList();
    }

    @GetMapping("/users/{id}")
    public UserResponse findById(@PathVariable Long id) {
        UserDto dto = this.userService.findById(id);
        return this.userMapper.dtoToResponse(dto);
    }

    @PostMapping("/users/")
    public UserResponse createUser(SignUpRequest request) {
        return this.signUp(request);
    }

    @PostMapping("/users/signUp")
    public UserResponse signUp(SignUpRequest request) {
        UserDto requestDto = UserDto.builder().build();
        UserDto dto = this.userService.signUp(requestDto);
        return this.userMapper.dtoToResponse(dto);
    }

    @PostMapping("/join")
    public UserResponse joinUser(SignUpRequest signUpRequest) {

        UserDto userDto = UserDto.builder()
                .birth(signUpRequest.getBirth())
                .careerStartAt(signUpRequest.getCareerStartAt())
                .createdAt(signUpRequest.getCreatedAt())
                .createdBy(signUpRequest.getCreatedBy())
                .email(signUpRequest.getEmail())
                .nickname(signUpRequest.getNickname())
                .password(signUpRequest.getPassword())
                .isActive(signUpRequest.isActive())
                .showsBirth(signUpRequest.isShowsBirth())
                .build();

        return userMapper.dtoToResponse(userService.joinUser(userDto));
    }

    @PostMapping("/users/signIn")
    public UserResponse signIn(SignInRequest request) {
        UserDto requestDto = UserDto.builder().build();
        UserDto dto = this.userService.signIn(requestDto);
        return this.userMapper.dtoToResponse(dto);
    }

    @PostMapping("/signIn")
    public UserResponse login(SignInRequest signInRequest) {
        UserDto userDto = UserDto.builder()
                .email(signInRequest.getEmail())
                .password(signInRequest.getPassword())
                .build();
        return userMapper.dtoToResponse(userService.signIn(userDto));
    }

    @PutMapping("/users/{id}/password")
    public UserResponse updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordRequest request) {
        UserDto dto = this.userService.updatePassword(id, request.password());
        return this.userMapper.dtoToResponse(dto);
    }

    @DeleteMapping("/users/{id}")
    public Boolean signOut(@PathVariable Long id) {
        return this.userService.signOut(id);
    }
}
