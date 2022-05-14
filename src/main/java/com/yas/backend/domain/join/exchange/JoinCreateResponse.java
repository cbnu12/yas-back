package com.yas.backend.domain.join.exchange;

import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class JoinCreateResponse {
    private Long joinId;
    public static JoinCreateResponse of(Long joinId){

        return JoinCreateResponse.builder()
                .joinId(joinId)
                .build();
    }
}


