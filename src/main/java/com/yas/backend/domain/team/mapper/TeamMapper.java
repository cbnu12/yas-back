package com.yas.backend.domain.team.mapper;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.team.Team;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.value.TeamInfo;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    private final UserMapper userMapper;
    private final UserService userService;

    public Team dtoToDomain(final TeamDto teamDto) {
        return Team.builder()
                .info(TeamInfo.of(teamDto.getId(), teamDto.getName(), teamDto.getDescription(), teamDto.getMaxMemberCount(), LocalDateTime.now()))
                .ownerId(teamDto.getOwnerId())
                .memberIds(teamDto.getMemberIds())
                .mainTechStackId(teamDto.getMainTechStackId())
                .techStackIds(teamDto.getTechStackIds())
                .teamStatus(teamDto.getTeamStatus())
                .build();
    }

    public TeamEntity dtoToEntity(final TeamDto teamDto) {
        UserDto userDto = userService.findById(teamDto.getOwnerId())
                .orElseThrow(UserNotFoundException::new);

        return TeamEntity.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .maxMemberCount(teamDto.getMaxMemberCount())
                .description(teamDto.getDescription())
                .owner(userMapper.dtoToEntity(userDto))
                .status(teamDto.getTeamStatus())
                .build();
    }

    public TeamDto entityToDto(final TeamEntity entity) {
        return TeamDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .maxMemberCount(entity.getMaxMemberCount())
                .currentUserCount(entity.getJoins().stream().filter(JoinEntity::getIsAlive).count())
                .description(entity.getDescription())
                .ownerId(entity.getOwner().getId())
                .memberIds(entity.getJoins().stream()
                        .map(JoinEntity::getUser)
                        .map(UserEntity::getId)
                        .collect(Collectors.toSet()))
                .teamStatus(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public TeamDto domainToDto(final Team team) {
        return TeamDto.builder()
                .id(team.getInfo().getId())
                .name(team.getInfo().getName())
                .description(team.getInfo().getDescription())
                .ownerId(team.getOwnerId())
                .maxMemberCount(team.getInfo().getMaxMemberCount())
                .currentUserCount((long) team.getMemberIds().size())
                .memberIds(team.getMemberIds())
                .mainTechStackId(team.getMainTechStackId())
                .techStackIds(team.getTechStackIds())
                .createdAt(team.getInfo().getCreatedAt())
                .build();
    }
}
