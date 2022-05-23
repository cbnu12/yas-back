package com.yas.backend.domain.user.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.file.service.StorageService;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.exchange.request.SignUpRequest;
import com.yas.backend.domain.user.exchange.request.UpdatePasswordRequest;
import com.yas.backend.domain.user.service.application.UserCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Tag(name = "Users", description = "사용자 API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserCommandController extends BaseController {
    private final UserCommandService userCommandService;
    private final StorageService storageService;

    @PostMapping("user")
    @Operation(summary = "사용자 계정 생성", description = "/api/SignUp EndPoint 동일 기능")
    public Long create(@RequestBody SignUpRequest request) {
        return this.signUp(request);
    }

    @PostMapping("signUp")
    @Operation(summary = "사용자 계정 생성", description = "/api/user EndPoint 동일 기능")
    public Long signUp(@RequestBody SignUpRequest request) {
        return this.userCommandService.signUp(request.toDto()).getId();
    }

    @PatchMapping("user/{id}/password")
    @Operation(summary = "패스워드 변경", description = "로그인 후 설정에서 패스워드 변경 시 호출되는 API")
    public Boolean updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordRequest request) {
        UserDto dto = this.userCommandService.updatePassword(id, request);
        return dto.getPassword().equals(request.getNewPassword());
    }

    @PatchMapping(value = "user/{id}/profileImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "프로필 사진 변경", description = "Multipart/form")
    public Boolean updateProfileImage(@PathVariable Long id, @RequestBody MultipartFile file) {
        String fileId = storageService.store(file, "profile", LocalDate.now().plusYears(100));
        UserDto dto = this.userCommandService.updateProfileImage(id, fileId);
        return dto.getProfileImage().equals(fileId);
    }

    @DeleteMapping("user/{id}")
    @Operation(summary = "사용자 회원탈퇴", description = "Soft Delete")
    public Boolean unRegister(@PathVariable Long id) {
        UserDto dto = this.userCommandService.unRegister(id);
        return dto.isDeleted();
    }
}
