package com.yas.backend.domain.invitation.exchange;

import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InvitationResponse {
    private UserDto user;
    private TeamDto team;
}
