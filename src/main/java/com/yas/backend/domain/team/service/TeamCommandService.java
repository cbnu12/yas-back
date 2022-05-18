package com.yas.backend.domain.team.service.application;

import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.team.Team;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamCommandService {

    private final TeamMapper teamMapper;
    private final TeamService teamService;

    public Long create(final TeamDto teamDto) {
        try {
            Team team = Team.create(teamDto);
            return teamService.create(teamMapper.domainToDto(team)).getId();
        } catch (UserNotFoundException e) {
            log.info(e.getMessage());
            throw new UserNotFoundException();
        }
    }

    public void remove(Long teamId) {
        Team team = teamMapper.dtoToDomain(teamService.findById(teamId));
        team.deactivate();
        teamService.save(teamMapper.domainToDto(team));
    }
}
