package com.yas.backend.domain.team.exchange;

import com.yas.backend.domain.team.dto.TeamDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class TeamSearchResponse {

    private Long id;
    private String name;
    private Long maxUserCount;
    private Long currentUserCount;
    private Set<String> techStacks;

    public static TeamSearchResponse of(TeamDto teamDto) {
        return TeamSearchResponse.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .maxUserCount(teamDto.getMaxUserCount())
                .currentUserCount(teamDto.getCurrentUserCount())
                .techStacks(teamDto.getTechStacks())
                .build();
    }
}
