package com.yas.backend.domain.invitation.repository;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.InvitationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InvitationQueryRepository {
    Page<InvitationEntity> findByPredicate(BooleanBuilder builder, Pageable pageable);
}
