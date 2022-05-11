package com.yas.backend.domain.team.service;

import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.service.domainservice.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamSearchService {

    private final TeamService teamService;
    private final TeamMapper teamMapper;

    public TeamDto findTeamByName(TeamDto teamDto){return teamService.findByName(teamDto.name());}

}
