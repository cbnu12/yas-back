package com.yas.backend.domain.user.service;

import com.yas.backend.domain.user.data.dto.UserDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.service.domainservice.UserService;
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

    public UserDto findUserByEmail(UserDto userDto) {
        return userService.findByEmail(userDto.getEmail());
    }

    public List<UserDto> findAllActiveUser() {
        return userService.findAllUserByIsActive();
    }
}
