package com.yas.backend.domain.user.controller;

import com.yas.backend.domain.user.dto.SignInRequest;
import com.yas.backend.domain.user.dto.SignUpRequest;
import com.yas.backend.domain.user.dto.SignInRequest;
import com.yas.backend.domain.user.dto.SignUpRequest;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.dto.UpdatePasswordRequest;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.response.UserResponse;
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

    @PostMapping("/users/signUp")
    public UserResponse createUser(SignUpRequest signUpRequest) {

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

        return userMapper.dtoToResponse(userService.signUp(userDto));
    }



    @PostMapping("/users/signIn")
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
