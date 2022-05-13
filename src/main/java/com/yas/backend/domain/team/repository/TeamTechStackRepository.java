package com.yas.backend.domain.team.repository;

import com.yas.backend.common.entity.TeamTechStackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamTechStackRepository extends JpaRepository<TeamTechStackEntity, Long> {

    List<TeamTechStackEntity> findByTeamId(Long teamId);
}
