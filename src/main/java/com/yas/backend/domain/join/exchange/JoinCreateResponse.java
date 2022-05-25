package com.yas.backend.domain.join.exchange;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class JoinCreateResponse {
    private Long joinId;

    public static JoinCreateResponse of(Long joinId) {
        return JoinCreateResponse.builder()
                .joinId(joinId)
                .build();
    }
}


