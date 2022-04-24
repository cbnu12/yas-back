package com.yas.backend.domain.user.service;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.InvalidPasswordException;
import com.yas.backend.common.exception.SignOverException;
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
        UserEntity userEntity = userMapper.dtoToEntity(userDto);
        return userMapper.entityToDto(this.userRepository.save(userEntity));
    }

    public UserDto signIn(UserDto userDto) {
       UserEntity userEntity = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(UserNotFoundException::new);

        if (userEntity.getSignInFailCount()>4) {
            throw new SignOverException();
        }else if (!userEntity.getPassword().equals(userDto.getPassword())) {
            userEntity.setSignInFailCount(userEntity.getSignInFailCount()+1);
            userRepository.save(userEntity);
            throw new InvalidPasswordException();
        }
        return userDto;
    }

    public UserDto updatePassword(Long id, String oldPassword, String newPassword) {
        UserEntity entity = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if (!entity.getPassword().equals(oldPassword)) throw new InvalidPasswordException();

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
