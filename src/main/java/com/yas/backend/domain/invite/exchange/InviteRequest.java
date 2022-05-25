package com.yas.backend.domain.invite.exchange;

import com.yas.backend.domain.invite.dto.InviteDto;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.dto.UserDto;

public record InviteRequest(
        Long id,
        UserDto user,
        TeamDto team,
        String createBy,
        String updatedBy


) {
    public InviteDto toDto() {
        return InviteDto.builder()
                .id(this.id)
                .user(this.user)
                .team(this.team)
                .updatedBy(this.updatedBy)
                .createdBy(this.createBy)
                .build();
    }
}
