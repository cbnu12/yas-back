package com.yas.backend.domain.team.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.yas.backend.common.entity.QTeamEntity;

public class TeamPredicate {

    private TeamPredicate() {
        throw new IllegalStateException("Utility class");
    }

    public static Predicate search(String name){
        QTeamEntity team = QTeamEntity.teamEntity;

        BooleanBuilder builder = new BooleanBuilder();

        if(name != null){
            builder.and(team.name.eq(name));
        }

        return builder;
    }
}
