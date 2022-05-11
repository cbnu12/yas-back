package com.yas.backend.domain.user.repository;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.domain.user.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>, QuerydslPredicateExecutor<UserDto> {
    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findByIsActive(boolean isActive);
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
