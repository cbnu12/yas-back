package com.yas.backend.domain.user.service;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.enums.LoginResponseCode;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.data.User;
import com.yas.backend.domain.user.data.dto.UserDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.data.response.LoginResponse;
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
        UserEntity userEntity= userMapper.dtoToEntity(userDto);
        return userMapper.entityToDto(this.userRepository.save(userEntity));
    }

    public LoginResponse login(UserDto userDto){
        LoginResponse loginResponse= new LoginResponse();
        if (userRepository.findByEmail(userDto.getEmail()).isEmpty()){
            loginResponse.setLoginResponseCode(LoginResponseCode.FAIL_EMAIL);
        }else if (userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword()).isEmpty()){
            loginResponse.setLoginResponseCode(LoginResponseCode.FAIL_PASSWORD);
        }else{
            loginResponse.setLoginResponseCode(LoginResponseCode.SUCCESS);
        }
        return loginResponse;
    }
}
