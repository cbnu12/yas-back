package com.yas.backend.domain.join.dto;

import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.enums.JoinStatus;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class JoinDto {
    private Long id;
    private Long userId;
    private Long teamId;
    private String updatedBy;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private JoinStatus status;
    private Boolean isAlive;

}
