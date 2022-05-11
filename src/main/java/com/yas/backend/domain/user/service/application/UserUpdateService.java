package com.yas.backend.domain.user.service.application;

import com.yas.backend.common.exception.PasswordComplexityException;
import com.yas.backend.domain.user.User;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUpdateService {
    private final UserService userService;
    private final UserMapper mapper;

    public UserDto updatePassword(UserDto dto, String newPassword) {
        User user = this.mapper.dtoToDomain(dto);
        if (user.updatePassword(newPassword)) throw new PasswordComplexityException();
        UserDto result = this.mapper.domainToDto(user);

        return this.userService.update(result);
    }
}
