package com.yas.backend.domain.team.repository;

import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.domain.team.dto.TeamPredicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TeamCustomRepositoryImpl implements TeamCustomRepository{

    @Override
    public Page<TeamEntity> findBySpecification(TeamPredicate teamSpecification, Pageable pageable) {
        return null;
    }


}
