package com.yas.backend.domain.team.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yas.backend.common.entity.QJoinEntity;
import com.yas.backend.common.entity.QTeamEntity;
import com.yas.backend.common.entity.TeamEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class TeamCustomRepositoryImpl implements TeamCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<TeamEntity> findByPredicate(BooleanBuilder teamPredicate, Pageable pageable) {

        QTeamEntity teamEntity = QTeamEntity.teamEntity;
        QJoinEntity joinEntity = QJoinEntity.joinEntity;

        List<TeamEntity> results = queryFactory.selectFrom(teamEntity)
                .leftJoin(joinEntity)
                .on(joinEntity.team.eq(teamEntity))
                .where(teamPredicate)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long count = queryFactory.selectFrom(teamEntity)
                .leftJoin(joinEntity)
                .on(joinEntity.team.eq(teamEntity))
                .where(teamPredicate)
                .fetch().size();

        return new PageImpl<>(results, pageable, count);
    }


}
