package com.yas.backend.domain.team.dto;

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
    private Long maxUserCount;
    private Long currentUserCount;
    private Long ownerId;
    private String topic;
    private Set<String> techStacks;
    private Set<Long> userIds;
    private LocalDateTime createdAt;
}
