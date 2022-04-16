package com.yas.backend.domain.user.service;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.InvalidPasswordException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.data.User;
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

    public List<UserDto> findAllActiveUser() {
        List<User> users = userRepository.findAll().stream()
                .filter(UserEntity::isActive)
                .map(userMapper::entityToDomain)
                .toList();

        return users.stream().map(userMapper::domainToDto).toList();
    }

    public UserDto findUserByEmail(String email) {
        return userMapper.entityToDto(userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new));
    }

    public UserDto joinUser(UserDto userDto) {
        UserEntity userEntity = userMapper.dtoToEntity(userDto);
        return userMapper.entityToDto(this.userRepository.save(userEntity));
    }

    public UserDto signIn(UserDto userDto) {


        String realPassword = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(UserNotFoundException::new)
                .getPassword();

        if (realPassword.equals(userDto.getPassword())) {
            throw new InvalidPasswordException();
        }
        return userDto;
    }
}
