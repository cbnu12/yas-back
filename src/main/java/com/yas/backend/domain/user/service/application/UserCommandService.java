package com.yas.backend.domain.user.service.application;

import com.yas.backend.common.exception.InsertConflictException;
import com.yas.backend.common.exception.PasswordNotMatchException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.User;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.exchange.request.UpdatePasswordRequest;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandService {
    private final UserService userService;
    private final UserMapper mapper;

    public UserDto signUp(UserDto dto) {
        User user = mapper.dtoToDomain(dto);
        if (userService.findByEmail(dto.getEmail()).isPresent())
            throw new InsertConflictException();
        UserDto result = mapper.domainToDto(user);

        return userService.create(result);
    }

    public UserDto updatePassword(Long id, UpdatePasswordRequest request) {
        User user = this.userService.findById(id).map(this.mapper::dtoToDomain).orElseThrow(UserNotFoundException::new);
        if (!user.validatePassword(request.oldPassword())) throw new PasswordNotMatchException();
        user.updatePassword(request.newPassword());
        UserDto result = this.mapper.domainToDto(user);

        return this.userService.update(result);
    }
}
