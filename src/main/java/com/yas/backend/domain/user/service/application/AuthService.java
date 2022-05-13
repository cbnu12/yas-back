package com.yas.backend.domain.user.service.application;

import com.yas.backend.common.exception.PasswordFailOverException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.User;
import com.yas.backend.domain.user.dto.AuthDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final UserMapper mapper;

    public boolean isValid(AuthDto authDto) {
        User user = this.userService.findByEmail(authDto.email())
                .map(this.mapper::dtoToDomain)
                .orElseThrow(UserNotFoundException::new);

        if (user.getSignInFailCount() > 5) throw new PasswordFailOverException();

        if (user.validatePassword(authDto.password())) return true;

        user.increasePasswordFailCount();
        this.userService.save(this.mapper.domainToDto(user));

        return false;
    }
}
