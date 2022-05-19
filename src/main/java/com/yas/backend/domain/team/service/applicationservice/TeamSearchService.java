package com.yas.backend.domain.team.service.applicationservice;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.dto.TeamPredicate;
import com.yas.backend.domain.team.exchange.TeamSearchRequest;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamSearchService {

    private final TeamMapper teamMapper;
    private final TeamService teamService;

    public Page<TeamDto> getTeams(final TeamSearchRequest teamSearchRequest, final Pageable pageable) {
        BooleanBuilder teamPredicate = TeamPredicate.teamPredicate(teamSearchRequest);
        return teamService.findByPredicate(teamPredicate, pageable)
                .map(teamMapper::entityToDto);
    }

    public TeamDto getTeam(Long teamId) {
        return teamService.findById(teamId);
    }
}
