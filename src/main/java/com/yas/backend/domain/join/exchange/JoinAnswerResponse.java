package com.yas.backend.domain.join.exchange;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class JoinAnswerResponse {
    private Long joinId;

    public static JoinAnswerResponse of(Long joinId){
        return JoinAnswerResponse.builder()
                .joinId(joinId)
                .build();
    }
}
