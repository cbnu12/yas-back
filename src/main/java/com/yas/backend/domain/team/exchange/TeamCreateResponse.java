package com.yas.backend.domain.team.exchange;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class TeamCreateResponse {
    private Long teamId;

    public static TeamCreateResponse of(Long teamId) {
        return TeamCreateResponse.builder()
                .teamId(teamId)
                .build();
    }
}
