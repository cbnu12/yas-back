package com.yas.backend.domain.join.repository;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.JoinEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JoinQueryRepository {
    Page<JoinEntity> findByPredicate(BooleanBuilder builder, Pageable pageable);
}
