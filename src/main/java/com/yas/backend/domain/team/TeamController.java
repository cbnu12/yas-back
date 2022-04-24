package com.yas.backend.domain.team;

import com.yas.backend.domain.team.dto.TeamCreateRequest;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.service.application.TeamCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Tag(name = "Teams", description = "팀 API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/teams")
public class TeamController {
    private final TeamCreateService teamCreateService;

    @PostMapping
    @Operation(summary = "팀 생성", description = "Request를 입력받아 팀 데이터 생성")
    public Long createTeam(@Parameter(hidden = true) @RequestHeader(value = "X-USER-ID") final Long ownerId,
                           final TeamCreateRequest request) {
        return teamCreateService.create(createRequestToDto(ownerId, request));
    }

    @GetMapping
    @Operation(summary = "팀 정보 조회", description = "파라미터 없이 전체 데이터 조회")
    public String getTeam() {
        return "TEST";
    }

    private TeamDto createRequestToDto(final Long ownerId, final TeamCreateRequest request) {
        return new TeamDto(
                null ,
                request.name(),
                request.meetingMethod(),
                request.totalUserCount(),
                request.description(),
                ownerId,
                new ArrayList<>(),
                request.hashtags(),
                request.techStacks(),
                request.joinConditions(),
                request.meetingCycle(),
                new ArrayList<>(),
                LocalDateTime.now()
        );
    }
}
