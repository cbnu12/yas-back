package com.yas.backend.domain.team.value;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamInfo {
    private Long id;
    private String name;
    private String description;
    private Long maxMemberCount;
    private LocalDateTime createdAt;


    public static TeamInfo of(Long id, String name, String description,Long maxMemberCount , LocalDateTime createdAt) {
        return new TeamInfo(id, name, description, maxMemberCount, createdAt);
    }
}
