package com.yas.backend.domain.user.service;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.InvalidPasswordException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.data.User;
import com.yas.backend.domain.user.data.dto.UserDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
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

    public UserDto signUp(UserDto dto) {
        UserEntity entity = this.userMapper.dtoToEntity(dto);
        UserEntity createResult = this.userRepository.save(entity);
        return this.userMapper.entityToDto(createResult);
    }

    public UserDto signIn(UserDto dto) {
        UserEntity entity = this.userRepository.findByEmail(dto.getEmail()).orElseThrow(UserNotFoundException::new);
        if (!entity.getPassword().equals(dto.getPassword())) {
            throw new UserNotFoundException();
        }
        return this.userMapper.entityToDto(entity);
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
    public UserDto updatePassword(Long id, String password) {
        UserEntity entity = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        entity.setPassword(password);
        UserEntity updateEntity = this.userRepository.save(entity);
        return this.userMapper.entityToDto(updateEntity);
    }

    public Boolean signOut(Long id) {
        UserEntity entity = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        this.userRepository.delete(entity);
        return true;
    }
}
