package com.yas.backend.domain.join.exchange;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class JoinDeleteResponse {
    private  Long joinId;

    public static JoinDeleteResponse of(Long joinId){
        return JoinDeleteResponse.builder()
                .joinId(joinId)
                .build();
    }
}
