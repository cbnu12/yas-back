package com.yas.backend.domain.team;

import com.google.common.collect.Sets;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.value.TeamInfo;
import com.yas.backend.domain.team.value.TeamStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Builder
public class Team {

    private TeamInfo info;
    private Long ownerId;
    private Set<Long> memberIds;
    private Long mainTechStackId;
    private Set<Long> techStackIds;
    private TeamStatus teamStatus;

    public static Team create(TeamDto teamDto) {
        return Team.builder()
                .info(TeamInfo.of(teamDto.getId(), teamDto.getName(), teamDto.getDescription(), teamDto.getMaxMemberCount(), LocalDateTime.now()))
                .ownerId(teamDto.getOwnerId())
                // TODO: 2022/06/04 please fix me
                .memberIds(teamDto.getMemberIds() == null ? Sets.newHashSet() : teamDto.getMemberIds())
                .mainTechStackId(teamDto.getMainTechStackId())
                .techStackIds(teamDto.getTechStackIds())
                .teamStatus(TeamStatus.ACTIVE)
                .build();
    }

    public void deactivate() {
        teamStatus = TeamStatus.INACTIVE;
    }
}
