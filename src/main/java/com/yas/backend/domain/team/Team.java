package com.yas.backend.domain.team;

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
    private Integer maxUserCount;
    private Long ownerId;
    private String topic;
    private Set<String> techStacks;
    private Set<Long> userIds;
    private Boolean isActive;
    private LocalDateTime createdAt;

    public void deactivate() {
        this.isActive = Boolean.FALSE;
    }
}
