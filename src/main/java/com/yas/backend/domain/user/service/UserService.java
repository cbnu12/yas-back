package com.yas.backend.domain.user.service;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.domain.user.data.User;
import com.yas.backend.domain.user.data.dto.UserDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.data.response.UserResponse;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAllActiveUser() {
        List<User> users = userRepository.findAll().stream()
                .filter(UserEntity::isActive)
                .map(userMapper::entityToDomain)
                .toList();

        return users.stream().map(userMapper::domainToDto).toList();
    }

    public UserResponse findActiveUserByEmail(String email) {
        return userMapper.dtoToResponse(userMapper.domainToDto(userMapper.entityToDomain(userRepository.findByEmail(email).orElse(null))));
    }
}
