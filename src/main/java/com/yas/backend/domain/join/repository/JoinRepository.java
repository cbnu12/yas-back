package com.yas.backend.domain.join.repository;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JoinRepository extends JpaRepository<JoinEntity, Long> {
    Optional<JoinEntity> findByUserAndTeam(UserEntity userEntity, TeamEntity team);

    List<JoinEntity> findByTeamId(Long teamId);
}
