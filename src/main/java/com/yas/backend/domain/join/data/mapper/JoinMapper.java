package com.yas.backend.domain.join.data.mapper;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.join.Join;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.repository.TeamRepository;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JoinMapper {
    private final UserMapper userMapper;
    private final TeamMapper teamMapper;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public JoinEntity dtoToEntity(JoinDto dto) {
        return JoinEntity.builder()
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

    public JoinDto entityToDto(JoinEntity entity) {
        return JoinDto.builder()
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

    public JoinDto domainToDto(Join join) {
        return JoinDto.builder()
                .id(join.getId())
                .status(join.getStatus())
                .teamId(join.getTeamId())
                .userId(join.getUserId())
                .isAlive(join.getIsAlive())
                .updatedAt(join.getUpdatedAt())
                .updatedBy(join.getUpdatedBy())
                .createdAt(join.getCreatedAt())
                .createdBy(join.getCreatedBy())
                .build();
    }

}
