package com.yas.backend.domain.team.mapper;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.team.Team;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    private final UserRepository userRepository;

    public Team dtoToDomain(final TeamDto teamDto) {
        return Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .maxUserCount(teamDto.getMaxUserCount())
                .description(teamDto.getDescription())
                .ownerId(teamDto.getOwnerId())
                .userIds(teamDto.getUserIds())
                .techStacks(teamDto.getTechStacks())
                .createdAt(teamDto.getCreatedAt())
                .build();
    }

    public TeamEntity dtoToEntity(final TeamDto teamDto) {
        return TeamEntity.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .maxUserCount(teamDto.getMaxUserCount())
                .description(teamDto.getDescription())
                .owner(userRepository.findById(teamDto.getOwnerId())
                        .orElseThrow(UserNotFoundException::new))
                .build();
    }

    public TeamDto entityToDto(final TeamEntity teamEntity) {
        return TeamDto.builder()
                .id(teamEntity.getId())
                .name(teamEntity.getName())
                .maxUserCount(teamEntity.getMaxUserCount())
                .description(teamEntity.getDescription())
                .ownerId(teamEntity.getOwner().getId())
                .userIds(teamEntity.getJoins().stream()
                        .map(JoinEntity::getUser)
                        .map(UserEntity::getId)
                        .collect(Collectors.toSet()))
                .createdAt(teamEntity.getCreatedAt())
                .build();
    }


    public TeamDto domainToDto(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .description(team.getDescription())
                .ownerId(team.getOwnerId())
                .maxUserCount(team.getMaxUserCount())
                .userIds(team.getUserIds())
                .techStacks(team.getTechStacks())
                .createdAt(team.getCreatedAt())
                .build();
    }
}
