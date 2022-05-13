package com.yas.backend.domain.team;

import com.yas.backend.domain.team.dto.TeamDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Builder
public class Team {

    private Long id;
    private String name;
    private String description;
    private Long maxUserCount;
    private Long currentUserCount;
    private Long ownerId;
    private String topic;
    private Set<String> techStacks;
    private Set<Long> userIds;
    private Boolean isActive;
    private LocalDateTime createdAt;

    public static Team create(TeamDto teamDto) {
        return Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .maxUserCount(teamDto.getMaxUserCount())
                .description(teamDto.getDescription())
                .ownerId(teamDto.getOwnerId())
                .userIds(teamDto.getUserIds())
                .techStacks(teamDto.getTechStacks())
                .createdAt(teamDto.getCreatedAt())
                .build();
    }

    public void deactivate() {
        this.isActive = Boolean.FALSE;
    }
}
