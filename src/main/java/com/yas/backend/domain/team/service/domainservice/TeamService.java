package com.yas.backend.domain.team.service;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;

    public TeamDto findById(Long teamId) {
        TeamEntity teamEntity = teamRepository.findById(teamId)
                .orElseThrow(TeamNotFoundException::new);
        return teamMapper.entityToDto(teamEntity);
    }

    @Transactional
    public TeamDto create(TeamDto teamDto) {
        TeamEntity teamEntity = teamMapper.dtoToEntity(teamDto);
        return teamMapper.entityToDto(teamRepository.save(teamEntity));
    }

    @Transactional
    public TeamDto save(TeamDto teamDto) {
        TeamEntity teamEntity = teamRepository.save(teamMapper.dtoToEntity(teamDto));
        return teamMapper.entityToDto(teamEntity);
    }

    public Page<TeamEntity> findByPredicate(final BooleanBuilder teamPredicate, final Pageable pageable) {
         return teamRepository.findByPredicate(teamPredicate, pageable);
    }
}
