package com.yas.backend.domain.user.service;

import com.yas.backend.domain.user.dto.AuthDto;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.service.domainservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;

    public boolean isValid(AuthDto authDto) {
        UserDto userDto = UserDto.builder()
                .email(authDto.email())
                .password(authDto.password())
                .build();

        return userService.findByEmailAndPassword(userDto)
                .isPresent();
    }
}
