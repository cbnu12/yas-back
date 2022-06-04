package com.yas.backend.domain.invitation.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yas.backend.common.entity.InvitationEntity;
import com.yas.backend.common.entity.QInvitationEntity;
import com.yas.backend.common.entity.QTeamEntity;
import com.yas.backend.common.entity.QUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class InvitationQueryRepositoryImpl implements InvitationQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<InvitationEntity> findByPredicate(BooleanBuilder builder, Pageable pageable) {
        QInvitationEntity invitationEntity = QInvitationEntity.invitationEntity;
        QTeamEntity teamEntity = QTeamEntity.teamEntity;
        QUserEntity userEntity = QUserEntity.userEntity;

        List<InvitationEntity> results = jpaQueryFactory.selectFrom(invitationEntity)
                .innerJoin(invitationEntity.team, teamEntity)
                .innerJoin(invitationEntity.user, userEntity)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long count = jpaQueryFactory.selectFrom(invitationEntity)
                .innerJoin(invitationEntity.team, teamEntity)
                .innerJoin(invitationEntity.user, userEntity)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch().size();

        return new PageImpl<>(results, pageable, count);

    }
}
