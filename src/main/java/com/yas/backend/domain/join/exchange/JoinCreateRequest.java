package com.yas.backend.domain.join.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yas.backend.domain.join.dto.JoinDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.mapping.Join;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinCreateRequest {

    @Schema(description = "사용자아이디")
    @JsonProperty("userId")
    private long userId;
    @Schema(description = "팀아이디")
    @JsonProperty("teamId")
    private  long teamId;

    public JoinDto toDto(){
        return JoinDto.builder()
                .userId(userId)
                .teamId(teamId)
                .build();

    }


}
