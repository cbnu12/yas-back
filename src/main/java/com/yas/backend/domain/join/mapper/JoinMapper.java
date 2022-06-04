package com.yas.backend.domain.join.mapper;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.join.Join;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.team.service.TeamService;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JoinMapper {

    private final UserMapper userMapper;
    private final UserService userService;
    private final TeamMapper teamMapper;
    private final TeamService teamService;

    public JoinEntity dtoToEntity(JoinDto dto) {
        UserDto userDto = userService.findById(dto.getUserId())
                .orElseThrow(UserNotFoundException::new);

        TeamDto teamDto = teamService.findById(dto.getTeamId());

        return JoinEntity.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .user(userMapper.dtoToEntity(userDto))
                .team(teamMapper.dtoToEntity(teamDto))
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
                .createdAt(join.getCreatedAt())
                .createdBy(join.getCreatedBy())
                .build();
    }

    public Join dtoToDomain(JoinDto joinDto) {
        return Join.builder()
                .id(joinDto.getId())
                .status(joinDto.getStatus())
                .teamId(joinDto.getTeamId())
                .userId(joinDto.getUserId())
                .isAlive(joinDto.getIsAlive())
                .createdAt(joinDto.getCreatedAt())
                .createdBy(joinDto.getCreatedBy())
                .build();
    }
}
