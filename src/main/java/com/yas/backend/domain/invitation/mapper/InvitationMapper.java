package com.yas.backend.domain.invitation.mapper;

import com.yas.backend.common.entity.InvitationEntity;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.invitation.Invitation;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.service.TeamService;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvitationMapper {
    private final UserService userService;
    private final UserMapper userMapper;
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    public InvitationEntity dtoToEntity(InvitationDto dto) {
        UserEntity userEntity = userMapper.dtoToEntity(userService.findById(dto.getUserId())
                .orElseThrow(UserNotFoundException::new));
        TeamEntity teamEntity= teamMapper.dtoToEntity(teamService.findById(dto.getTeamId()));

        return InvitationEntity.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .user(userEntity)
                .team(teamEntity)
                .isAlive(dto.getIsAlive())
                .createdBy(dto.getCreatedBy())
                .createdAt(dto.getCreatedAt())
                .updatedBy(dto.getUpdatedBy())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }

    public InvitationDto entityToDto(InvitationEntity entity) {
        return InvitationDto.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .userId(entity.getUser().getId())
                .teamId(entity.getTeam().getId())
                .isAlive(entity.getIsAlive())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public InvitationDto domainToDto(Invitation invitation) {
        return InvitationDto.builder()
                .id(invitation.getId())
                .status(invitation.getStatus())
                .teamId(invitation.getTeamId())
                .userId(invitation.getUserId())
                .isAlive(invitation.getIsAlive())
                .updatedAt(invitation.getUpdatedAt())
                .updatedBy(invitation.getUpdatedBy())
                .createdAt(invitation.getCreatedAt())
                .createdBy(invitation.getCreatedBy())
                .build();
    }

}
