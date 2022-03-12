package com.yas.backend.domain.team;

import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.dto.TeamCreateRequest;
import com.yas.backend.domain.team.service.application.TeamCreateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@RestController("api/team")
public class TeamController {

    private final TeamCreateService teamCreateService;

    @PostMapping
    public Long createTeam(@RequestHeader(value = "X-USER-ID") final Long ownerId,
            final TeamCreateRequest request) {
        return teamCreateService.create(createRequestToDto(ownerId, request));
    }

    private TeamDto createRequestToDto(final Long ownerId, final TeamCreateRequest request) {
        return new TeamDto(
                null ,
                request.name(),
                request.meetingMethod(),
                request.totalMemberCount(),
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
