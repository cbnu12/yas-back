package com.yas.backend.domain.user.repository;

import com.yas.backend.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findByIsActive(boolean isActive);
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
