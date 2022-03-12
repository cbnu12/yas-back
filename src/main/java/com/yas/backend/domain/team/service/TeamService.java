package com.yas.backend.domain.team.service;

import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;

    public TeamDto create(TeamDto teamDto) {
        TeamEntity teamEntity = teamMapper.dtoToEntity(teamDto);
        return teamMapper.entityToDto(teamRepository.save(teamEntity));
    }
}
