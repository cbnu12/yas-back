package com.yas.backend.domain.user.service.domainservice;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.data.dto.UserDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        return userMapper.entityToDto(userEntity);
    }

    public List<UserDto> findAllUserByIsActive() {
        return userRepository.findByIsActive(Boolean.TRUE).stream()
                .map(userMapper::entityToDto)
                .toList();
    }
}
