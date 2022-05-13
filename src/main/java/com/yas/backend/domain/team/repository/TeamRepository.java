package com.yas.backend.domain.team.repository;

import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.domain.team.dto.TeamDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long>, TeamCustomRepository, QuerydslPredicateExecutor<TeamDto> {
}
