package com.yas.backend.domain.invite.dto;

import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InviteDto {
    private Long id;
    private UserDto user;
    private TeamDto team;
    private String updatedBy;
    private String createdBy;
}
