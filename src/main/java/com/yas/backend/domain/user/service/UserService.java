package com.yas.backend.domain.user.service;

import com.querydsl.core.BooleanBuilder;
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
    private final UserMapper mapper;

    public UserDto create(UserDto dto) {
        UserEntity entity = mapper.dtoToEntity(dto);
        UserEntity saveResult = userRepository.save(entity);
        return mapper.entityToDto(saveResult);
    }

    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(mapper::entityToDto);
    }

    public Optional<UserDto> findByEmail(String email) {
        return userRepository.findByEmail(email).map(mapper::entityToDto);
    }

    public List<UserDto> findByPredicate(BooleanBuilder predicate) {
        List<UserEntity> entities = this.userRepository.findByPredicate(predicate);
        return entities.stream().map(this.mapper::entityToDto).toList();
    }

    public UserDto update(UserDto dto) {
        if (dto.getId() == null) throw new UserNotFoundException();

        UserEntity entity = mapper.dtoToEntity(dto);
        UserEntity saveResult = userRepository.save(entity);
        return mapper.entityToDto(saveResult);
    }
}
