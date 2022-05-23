package com.yas.backend.domain.invitation.repository;


import com.yas.backend.common.entity.InvitationEntity;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface InvitationRepository extends JpaRepository<InvitationEntity, Long>, InvitationQueryRepository, QuerydslPredicateExecutor<InvitationDto> {
    Optional<InvitationEntity> findByUserAndTeam(UserEntity userEntity, TeamEntity team);
}
