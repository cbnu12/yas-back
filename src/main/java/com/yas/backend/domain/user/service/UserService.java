package com.yas.backend.domain.user.service;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.InvalidPasswordException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAll() {
        Stream<UserEntity> entities = this.userRepository.findAll().stream();
        return entities.map(this.userMapper::entityToDto).toList();
    }

    public UserDto findById(Long id) {
        UserEntity entity = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return this.userMapper.entityToDto(entity);
    }

    public UserDto signUp(UserDto userDto) {
        UserEntity userEntity = this.userMapper.dtoToEntity(userDto);
        return this.userMapper.entityToDto(this.userRepository.save(userEntity));
    }

    public UserDto signIn(UserDto userDto) {
        UserEntity entity = this.userRepository.findByEmail(userDto.getEmail()).orElseThrow(UserNotFoundException::new);
        if (entity.getPassword().equals(userDto.getPassword())) throw new InvalidPasswordException();

        return this.userMapper.entityToDto(entity);
    }

    public UserDto updatePassword(Long id, String oldPassword, String newPassword) {
        UserEntity entity = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if (entity.getPassword().equals(oldPassword)) throw new InvalidPasswordException();

        entity.setPassword(newPassword);
        UserEntity updateEntity = this.userRepository.save(entity);
        return this.userMapper.entityToDto(updateEntity);
    }

    public UserDto signOut(Long id) {
        UserEntity entity = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        entity.setActive(false);
        UserEntity deleteResult = this.userRepository.save(entity);
        return this.userMapper.entityToDto(deleteResult);
    }
}
