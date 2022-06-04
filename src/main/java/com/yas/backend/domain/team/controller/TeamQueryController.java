package com.yas.backend.domain.team.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.exchange.TeamSearchRequest;
import com.yas.backend.domain.team.exchange.TeamSearchResponse;
import com.yas.backend.domain.team.exchange.TeamsSearchResponse;
import com.yas.backend.domain.team.service.applicationservice.TeamSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Teams", description = "팀 query API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class TeamQueryController extends BaseController {

    private final TeamSearchService teamSearchService;

    @GetMapping("teams")
    @Operation(summary = "팀 목록 정보 조회", description = "팀 목록 데이터 조회")
    public TeamsSearchResponse getTeams(final TeamSearchRequest teamSearchRequest, final Pageable pageable) {
        Page<TeamDto> result = teamSearchService.getTeams(teamSearchRequest, pageable);
        return TeamsSearchResponse.of(result);
    }

    @GetMapping("team/{teamId}")
    @Operation(summary = "팀 정보 조회 by Id", description = "팀 데이터 조회")
    public TeamSearchResponse getTeam(@PathVariable("teamId") final Long teamId) {
        return TeamSearchResponse.of(teamSearchService.getTeam(teamId));
    }
}
