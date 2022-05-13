package com.yas.backend.domain.user.repository;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.UserEntity;

import java.util.List;

public interface UserQueryRepository {
    List<UserEntity> findByPredicate(BooleanBuilder builder);
}
