package com.yas.backend.domain.team.service.application;

import com.yas.backend.domain.team.Team;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamCreateService {

    private final TeamMapper teamMapper;
    private final TeamService teamService;

    public Long create(final TeamDto teamDto) {
        Team team = teamMapper.dtoToDomain(teamDto);
        return teamService.create(teamMapper.domainToDto(team)).id();
    }

    public TeamDto update(final TeamDto teamDto) {
        return teamDto;
    }

    public boolean delete() {
        return true;
    }
}
