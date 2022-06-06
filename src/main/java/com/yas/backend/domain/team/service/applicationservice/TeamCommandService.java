package com.yas.backend.domain.team.service.applicationservice;

import com.yas.backend.domain.join.Join;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.join.mapper.JoinMapper;
import com.yas.backend.domain.join.service.JoinService;
import com.yas.backend.domain.team.Team;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamCommandService {

    private final TeamMapper teamMapper;
    private final TeamService teamService;
    private final JoinMapper joinMapper;
    private final JoinService joinService;

    @Transactional
    public Long create(final TeamDto teamDto) {
        Team team = Team.create(teamDto);
        Long teamId = teamService.create(teamMapper.domainToDto(team)).getId();

        Join ownerJoin = Join.createForOwner(JoinDto.ofAccepted(team.getOwnerId(), teamId));
        joinService.create(joinMapper.domainToDto(ownerJoin));

        return teamId;
    }

    @Transactional
    public void remove(Long teamId) {
        Team team = teamMapper.dtoToDomain(teamService.findById(teamId));
        team.deactivate();

        List<Join> joins = joinService.findByTeamId(team.getInfo().getId()).stream()
                .map(joinMapper::dtoToDomain)
                .toList();
        joins.forEach(Join::deactivate);

        joinService.saveAll(joins.stream().map(joinMapper::domainToDto).toList());
        teamService.save(teamMapper.domainToDto(team));
    }
}
