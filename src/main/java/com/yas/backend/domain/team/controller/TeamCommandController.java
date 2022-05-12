package com.yas.backend.domain.team.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.exchange.TeamCreateRequest;
import com.yas.backend.domain.team.exchange.TeamCreateResponse;
import com.yas.backend.domain.team.service.application.TeamCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Teams command", description = "팀 command API")
public class TeamCommandController extends BaseController {
    private final TeamCommandService teamCommandService;

    @PostMapping(value = "team")
    @Operation(summary = "팀 생성", description = "Request를 입력받아 팀 생성")
    public TeamCreateResponse createTeam(@RequestBody final TeamCreateRequest request) {
        TeamDto teamDto = request.toDto();
        return TeamCreateResponse.of(teamCommandService.create(teamDto));
    }

    @DeleteMapping("team/{teamId}")
    @Operation(summary = "팀 삭제", description = "Request를 입력받아 팀 삭제")
    public void removeTeam(@PathVariable("teamId") Long teamId) {
        teamCommandService.remove(teamId);
    }
}
