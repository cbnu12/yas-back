package com.yas.backend.domain.team.controller;

import com.yas.backend.domain.team.exchange.TeamCreateRequest;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.exchange.TeamSearchRequest;
import com.yas.backend.domain.team.service.TeamSearchService;
import com.yas.backend.domain.team.service.application.TeamCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Teams", description = "팀 command API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class TeamCommandController {
    private final TeamCreateService teamCreateService;

    @PostMapping
    @Operation(summary = "팀 생성", description = "Request를 입력받아 팀 데이터 생성")
    public Long createTeam(final TeamCreateRequest request) {
        return 123L;
    }

    @PutMapping
    @Operation(summary = "팀 수정", description = "Request를 입력받아 팀 데이터 수정")
    public Long modifyTeam(final TeamCreateRequest request) {
        return 123L;
    }

    @DeleteMapping
    @Operation(summary = "팀 삭제", description = "Request를 입력받아 팀 데이터 삭제")
    public Long removeTeam(final TeamCreateRequest request) {
        return 123L;
    }
}
