package com.yas.backend.domain.team.dto;

import com.google.common.collect.Sets;
import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.QTeamEntity;
import com.yas.backend.common.entity.QTechStackEntity;
import com.yas.backend.domain.team.exchange.TeamSearchRequest;
import org.apache.commons.collections4.CollectionUtils;

public class TeamPredicate {

    private TeamPredicate() {
        throw new IllegalStateException("Utility class");
    }

    public static BooleanBuilder teamPredicate(TeamSearchRequest request) {
        return factoryBySearchType(request);
    }

    private static BooleanBuilder factoryBySearchType(TeamSearchRequest request) {
        return switch (request.getSearchType()) {
            case NAME -> searchByName(request);
            case TECHSTACK -> searchByTechStack(request);
            default -> new BooleanBuilder();
        };
    }

    private static BooleanBuilder searchByName(TeamSearchRequest request) {
        QTeamEntity team = QTeamEntity.teamEntity;
        BooleanBuilder builder = new BooleanBuilder();

        if(CollectionUtils.isNotEmpty(request.getKeywords())) {
            Sets.newHashSet(request.getKeywords())
                    .forEach(keyword -> builder.and(team.name.like(keyword)));
        }

        return builder;
    }

    private static BooleanBuilder searchByTechStack(TeamSearchRequest request) {
        QTechStackEntity techStack = QTechStackEntity.techStackEntity;
        BooleanBuilder builder = new BooleanBuilder();

        if(CollectionUtils.isNotEmpty(request.getKeywords())) {
            builder.and(techStack.name.in(Sets.newHashSet(request.getKeywords())));
        }

        return builder;
    }
}
