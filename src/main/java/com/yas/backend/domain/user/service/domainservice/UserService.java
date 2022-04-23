package com.yas.backend.domain.user.service.domainservice;

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

    public UserDto findByEmail(UserDto userDto) {
        UserEntity userEntity = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(UserNotFoundException::new);

        return userMapper.entityToDto(userEntity);
    }

}
