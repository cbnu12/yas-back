package com.yas.backend.domain.user.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yas.backend.common.entity.QUserEntity;
import com.yas.backend.common.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<UserEntity> findByPredicate(BooleanBuilder predicate, Pageable pageable) {
        QUserEntity userEntity = QUserEntity.userEntity;

        List<UserEntity> entities = this.queryFactory.selectFrom(userEntity)
                .where(predicate)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long count = entities.size();
        return new PageImpl<>(entities, pageable, count);
    }
}
