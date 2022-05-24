package com.yas.backend.domain.user.repository;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserQueryRepository {
    Page<UserEntity> findByPredicate(BooleanBuilder builder, Pageable pageable);
}
