package com.yas.backend.domain.join.repository;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinRepository extends JpaRepository<JoinEntity, Long> {
}
