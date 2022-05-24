package com.yas.backend.domain.user.service;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(mapper::entityToDto);
    }

    public Optional<UserDto> findByEmail(String email) {
        return userRepository.findByEmail(email).map(mapper::entityToDto);
    }

    public Page<UserDto> findByPredicate(BooleanBuilder predicate, Pageable pageable) {
        Page<UserEntity> entities = this.userRepository.findByPredicate(predicate, pageable);
        return entities.map(this.mapper::entityToDto);
    }

    public UserDto save(UserDto dto) {
        UserEntity entity = mapper.dtoToEntity(dto);
        UserEntity saveResult = userRepository.save(entity);
        return mapper.entityToDto(saveResult);
    }
}
