package com.yas.backend.domain.user.service.domainservice;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findById(Long id) {
        return userMapper.entityToDto(userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new));
    }

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

    public Optional<UserDto> findByEmailAndPassword(UserDto userDto) {
        return userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword())
                .map(userMapper::entityToDto);
    }
}
