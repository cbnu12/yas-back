package com.yas.backend.domain.user.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yas.backend.common.entity.QUserEntity;
import com.yas.backend.common.entity.UserEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<UserEntity> findByPredicate(BooleanBuilder predicate) {
        QUserEntity userEntity = QUserEntity.userEntity;

        return this.queryFactory.selectFrom(userEntity)
                .where(predicate)
                .fetch();
    }
}
