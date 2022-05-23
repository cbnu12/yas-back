package com.yas.backend.domain.invitation.dto;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.QInvitationEntity;
import com.yas.backend.common.entity.QTeamEntity;
import com.yas.backend.common.entity.QUserEntity;
import com.yas.backend.common.enums.InvitationStatus;
import com.yas.backend.domain.invitation.exchange.InvitationSearchRequest;

public class InvitationPredicate {
    private InvitationPredicate() {
        throw new IllegalStateException();
    }

    public static BooleanBuilder invitationPredicate(InvitationSearchRequest request) {
        return factoryBySearchType(request);
    }

    private static BooleanBuilder factoryBySearchType(InvitationSearchRequest request) {
        return switch (request.getSearchType()) {
            case TEAM_NAME -> searchByTeamName(request);
            case USER_EMAIL -> searchByUserEmail(request);
            case STATUS -> searchByStatus(request);
        };
    }

    private static BooleanBuilder searchByTeamName(InvitationSearchRequest request) {
        QInvitationEntity invitation = QInvitationEntity.invitationEntity;
        QTeamEntity team = QTeamEntity.teamEntity;
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(team.name.like(request.getTeamName()));

        return builder;
    }

    private static BooleanBuilder searchByUserEmail(InvitationSearchRequest request) {
        QInvitationEntity invitation = QInvitationEntity.invitationEntity;
        QUserEntity user = QUserEntity.userEntity;
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(user.email.eq(request.getUserEmail()));
        return builder;
    }

    private static BooleanBuilder searchByStatus(InvitationSearchRequest request) {
        QInvitationEntity invitation = QInvitationEntity.invitationEntity;
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(invitation.status.eq(InvitationStatus.valueOf(request.getStatus())));
        return builder;
    }
}
