package com.yas.backend.domain.user.specification;

import com.yas.backend.common.entity.UserEntity;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    private UserSpecification() {}

    public static Specification<UserEntity> equalEmail(String email) {
        return (root, query, builder) -> builder.equal(root.get("email"), email);
    }

    public static Specification<UserEntity> likeNickname(String nickname) {
        return (root, query, builder) -> builder.like(root.get("nickname"), "%" + nickname + "%");
    }

    public static Specification<UserEntity> isActive(boolean isActive) {
        return (root, query, builder) -> builder.equal(root.get("isActive"), isActive);
    }
}
