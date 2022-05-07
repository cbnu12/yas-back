package com.yas.backend.domain.team.service;

import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;

    public TeamDto create(TeamDto teamDto) {
        TeamEntity teamEntity = teamMapper.dtoToEntity(teamDto);
        return teamMapper.entityToDto(teamRepository.save(teamEntity));
    }

    public TeamDto findById(Long teamId) {
        TeamEntity teamEntity = teamRepository.findById(teamId)
                .orElseThrow(TeamNotFoundException::new);
        return teamMapper.entityToDto(teamEntity);
    }

    public List<TeamDto> findTeams() {
        return teamRepository.findAll().stream()
                .map(teamMapper::entityToDto)
                .toList();
    }
}
