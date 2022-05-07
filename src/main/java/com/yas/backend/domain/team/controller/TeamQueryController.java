package com.yas.backend.domain.team.controller;

import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.exchange.TeamSearchRequest;
import com.yas.backend.domain.team.service.TeamSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Teams", description = "팀 query API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class TeamQueryController {

    private final TeamSearchService teamSearchService;

    @GetMapping("teams")
    @Operation(summary = "팀 목록 정보 조회", description = "팀 목록 데이터 조회")
    public List<TeamDto> getTeams(TeamSearchRequest teamSearchRequest) {
        return teamSearchService.getTeams(teamSearchRequest);
    }

    @GetMapping("team/{teamId}")
    @Operation(summary = "팀 정보 조회 by Id", description = "팀 데이터 조회")
    public TeamDto getTeam(@PathVariable("teamId") Long teamId) {
        return teamSearchService.getTeam(teamId);
    }
}
