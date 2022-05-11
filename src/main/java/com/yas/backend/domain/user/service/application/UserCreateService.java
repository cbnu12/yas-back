package com.yas.backend.domain.user.service.application;

import com.yas.backend.common.exception.InsertConflictException;
import com.yas.backend.domain.user.User;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService {
    private final UserService userService;
    private final UserMapper mapper;

    public Long signUp(UserDto dto) {
        User user = mapper.dtoToDomain(dto);
        if (userService.findByEmail(dto.getEmail()).isPresent())
            throw new InsertConflictException();
        UserDto result = mapper.domainToDto(user);

        return userService.create(result).getId();
    }
}
