package com.yas.backend.domain.invitation.data.mapper;

import com.yas.backend.common.entity.InvitationEntity;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.invitation.Invitation;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.repository.TeamRepository;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvitationMapper {
    private final UserMapper userMapper;
    private final TeamMapper teamMapper;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public InvitationEntity dtoToEntity(InvitationDto dto) {
        return InvitationEntity.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .user(userRepository.findById(dto.getUserId())
                        .orElseThrow(UserNotFoundException::new))
                .team(teamRepository.findById(dto.getTeamId())
                        .orElseThrow(TeamNotFoundException::new))
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
