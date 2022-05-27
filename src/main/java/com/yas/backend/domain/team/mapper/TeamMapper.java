package com.yas.backend.domain.team.mapper;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.team.Team;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    private final UserMapper userMapper;
    private final UserService userService;

    public Team dtoToDomain(final TeamDto teamDto) {
        return Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .maxUserCount(teamDto.getMaxUserCount())
                .currentUserCount(teamDto.getCurrentUserCount())
                .description(teamDto.getDescription())
                .ownerId(teamDto.getOwnerId())
                .userIds(teamDto.getUserIds())
                .techStacks(teamDto.getTechStacks())
                .createdAt(teamDto.getCreatedAt())
                .build();
    }

    public TeamEntity dtoToEntity(final TeamDto teamDto) {
        UserDto userDto = userService.findById(teamDto.getOwnerId())
                .orElseThrow(UserNotFoundException::new);

        return TeamEntity.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .maxUserCount(teamDto.getMaxUserCount())
                .description(teamDto.getDescription())
                .owner(userMapper.dtoToEntity(userDto))
                .build();
    }

    public TeamDto entityToDto(final TeamEntity entity) {
        return TeamDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .maxUserCount(entity.getMaxUserCount())
                .currentUserCount(entity.getJoins().stream().filter(JoinEntity::getIsAlive).count())
                .description(entity.getDescription())
                .ownerId(entity.getOwner().getId())
                .userIds(entity.getJoins().stream()
                        .map(JoinEntity::getUser)
                        .map(UserEntity::getId)
                        .collect(Collectors.toSet()))
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public TeamDto domainToDto(final Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .description(team.getDescription())
                .ownerId(team.getOwnerId())
                .maxUserCount(team.getMaxUserCount())
                .currentUserCount(team.getCurrentUserCount())
                .userIds(team.getUserIds())
                .techStacks(team.getTechStacks())
                .createdAt(team.getCreatedAt())
                .build();
    }
}
