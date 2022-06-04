package com.yas.backend.domain.join.dto;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.QJoinEntity;
import com.yas.backend.common.entity.QTeamEntity;
import com.yas.backend.common.entity.QUserEntity;
import com.yas.backend.common.enums.JoinStatus;
import com.yas.backend.domain.join.exchange.JoinSearchRequest;

public class JoinPredicate {
    private JoinPredicate() {
        throw new IllegalStateException();
    }

    public static BooleanBuilder joinPredicate(JoinSearchRequest request) {
        return factoryBySearchType(request);
    }

    private static BooleanBuilder factoryBySearchType(JoinSearchRequest request) {
        return switch (request.getSearchType()) {
            case TEAM_NAME -> searchByTeamName(request);
            case USER_EMAIL -> searchByUserEmail(request);
            case STATUS -> searchByStatus(request);
        };
    }

    private static BooleanBuilder searchByTeamName(JoinSearchRequest request) {
        QJoinEntity join = QJoinEntity.joinEntity;
        QTeamEntity team = QTeamEntity.teamEntity;
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(team.name.like(request.getTeamName()));

        return builder;
    }

    private static BooleanBuilder searchByUserEmail(JoinSearchRequest request) {
        QJoinEntity join = QJoinEntity.joinEntity;
        QUserEntity user = QUserEntity.userEntity;
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(user.email.eq(request.getUserEmail()));
        return builder;
    }

    private static BooleanBuilder searchByStatus(JoinSearchRequest request) {
        QJoinEntity join = QJoinEntity.joinEntity;
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(join.status.eq(JoinStatus.valueOf(request.getStatus())));
        return builder;
    }
}
