package com.yas.backend.domain.join.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.dto.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;

public record JoinRequest(
        @Schema(description = "아이디")
        @JsonProperty("id")
        Long id,
        @Schema(description = "사용자")
        @JsonProperty("user")
        UserDto user,
        @Schema(description = "팀")
        @JsonProperty("team")
        TeamDto team,
        @Schema(description = "가입신청자")
        @JsonProperty("createBy")
        String createBy,
        @Schema(description = "수정자")
        @JsonProperty("updatedBy")
        String updatedBy


) {
    public JoinDto toDto() {
        return JoinDto.builder()
                .id(this.id)
                .user(this.user)
                .team(this.team)
                .updatedBy(this.updatedBy)
                .createdBy(this.createBy)
                .build();
    }
}
