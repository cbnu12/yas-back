package com.yas.backend.domain.team.dto;

import com.yas.backend.domain.team.value.TeamStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private Long id;
    private String name;
    private String description;
    private Long maxMemberCount;
    private Long currentUserCount;
    private Long ownerId;
    private Long mainTechStackId;
    private Set<Long> techStackIds;
    private Set<Long> memberIds;
    private TeamStatus teamStatus;
    private LocalDateTime createdAt;
}
