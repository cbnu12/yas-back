package com.yas.backend.domain.user.dto;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.QUserEntity;


public class UserPredicate {
    private UserPredicate() {
        throw new IllegalStateException("Utility class");
    }

    public static BooleanBuilder search(String email, String nickname) {
        QUserEntity user = QUserEntity.userEntity;
        BooleanBuilder builder = new BooleanBuilder();

        if (email != null) builder.and(user.email.eq(email));
        if (nickname != null) builder.and(user.nickname.eq(nickname));

        return builder;
    }
}
