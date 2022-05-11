package com.yas.backend.domain.user.service.application;

import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserSearchService {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserDto findById(Long id) {
        return userService.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public UserDto findUserByEmail(UserDto userDto) {
        return userService.findByEmail(userDto.getEmail()).orElseThrow(UserNotFoundException::new);
    }

    public List<UserDto> findAllActiveUser() {
        return userService.findAllUserByIsActive();
    }
}
