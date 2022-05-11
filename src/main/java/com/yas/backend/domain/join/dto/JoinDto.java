package com.yas.backend.domain.join.dto;

import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinDto {
    private Long id;
    private UserDto user;
    private TeamDto team;
    private String updatedBy;
    private String createdBy;


}
