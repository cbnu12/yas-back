package com.yas.backend.domain.invitation.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class InvitationCreateRequest {

    @Schema(description = "사용자아이디")
    @JsonProperty("userId")
    private long userId;
    @Schema(description = "팀아이디")
    @JsonProperty("teamId")
    private long teamId;

    public InvitationDto toDto() {
        return InvitationDto.builder()
                .userId(userId)
                .teamId(teamId)
                .build();

    }


}
