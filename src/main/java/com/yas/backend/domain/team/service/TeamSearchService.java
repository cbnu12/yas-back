package com.yas.backend.domain.team.service;

import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.exchange.TeamSearchRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamSearchService {

    private final TeamService teamService;

    public List<TeamDto> getTeams(TeamSearchRequest teamSearchRequest) {
        return teamService.findTeams();
    }

    public TeamDto getTeam(Long teamId) {
        return teamService.findById(teamId);
    }
}
