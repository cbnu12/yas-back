package com.yas.backend.domain.join.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.entity.QJoinEntity;
import com.yas.backend.common.entity.QTeamEntity;
import com.yas.backend.common.entity.QUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class JoinQueryRepositoryImpl implements JoinQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<JoinEntity> findByPredicate(BooleanBuilder builder, Pageable pageable) {
        QJoinEntity joinEntity = QJoinEntity.joinEntity;
        QTeamEntity teamEntity = QTeamEntity.teamEntity;
        QUserEntity userEntity = QUserEntity.userEntity;

        List<JoinEntity> results = jpaQueryFactory.selectFrom(joinEntity)
                .innerJoin(joinEntity.team, teamEntity)
                .innerJoin(joinEntity.user, userEntity)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long count = jpaQueryFactory.selectFrom(joinEntity)
                .innerJoin(joinEntity.team, teamEntity)
                .innerJoin(joinEntity.user, userEntity)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch().size();

        return new PageImpl<>(results, pageable, count);

    }
}
