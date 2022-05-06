package com.yas.backend.domain.user.service.domainservice;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.repository.UserRepository;
import com.yas.backend.domain.user.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
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

    public List<UserDto> findAll(String email, String nickname, Boolean isActive) {
        Specification<UserEntity> specification = (root, query, builder) -> null;
        if (email != null)
            specification = specification.and(UserSpecification.equalEmail(email));
        if (nickname != null)
            specification = specification.and(UserSpecification.likeNickname(nickname));
        if (isActive != null)
            specification = specification.and(UserSpecification.isActive(isActive));

        return userRepository.findAll(specification).stream().map(userMapper::entityToDto).toList();
    }

    public UserDto findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        return userMapper.entityToDto(userEntity);
    }

    public Optional<UserDto> findByEmailAndPassword(UserDto userDto) {
        return userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword())
                .map(userMapper::entityToDto);
    }
}
