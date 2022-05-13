package com.yas.backend.domain.team.service;

import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<TeamDto> findTeams() {
        return teamRepository.findAll().stream()
                .map(teamMapper::entityToDto)
                .toList();
    }

    @Transactional
    public TeamDto create(TeamDto teamDto) throws UserNotFoundException {
        TeamEntity teamEntity = teamMapper.dtoToEntity(teamDto);
        return teamMapper.entityToDto(teamRepository.save(teamEntity));
    }

    @Transactional
    public TeamDto save(TeamDto teamDto) {
        TeamEntity teamEntity = teamRepository.save(teamMapper.dtoToEntity(teamDto));
        return teamMapper.entityToDto(teamEntity);
    }
}
