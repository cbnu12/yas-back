package com.yas.backend.domain.team.mapper;

import com.yas.backend.common.entity.*;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.team.Team;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.repository.TeamTechStackRepository;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    private final UserRepository userRepository;
    private final TeamTechStackRepository teamTechStackRepository;

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

    public TeamDto entityToDto(final TeamEntity entity) {
        return TeamDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .maxUserCount(entity.getMaxUserCount())
                .description(entity.getDescription())
                .ownerId(entity.getOwner().getId())
                .userIds(entity.getJoins().stream()
                        .map(JoinEntity::getUser)
                        .map(UserEntity::getId)
                        .collect(Collectors.toSet()))
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public Team entityToDomain(final TeamEntity entity) {
        return Team.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .ownerId(entity.getOwner().getId())
                .maxUserCount(entity.getMaxUserCount())
                .topic(entity.getTopic().getName())
                .techStacks(teamTechStackRepository.findByTeamId(entity.getId()).stream()
                        .map(TeamTechStackEntity::getTechStack)
                        .map(TechStackEntity::getName)
                        .collect(Collectors.toSet()))
                .isActive(entity.isActive())
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
                .userIds(team.getUserIds())
                .techStacks(team.getTechStacks())
                .createdAt(team.getCreatedAt())
                .build();
    }

    public TeamEntity domainToEntity(final Team team) {
        return TeamEntity.builder()
                .id(team.getId())
                .name(team.getName())
                .maxUserCount(team.getMaxUserCount())
                .description(team.getDescription())
                .owner(userRepository.findById(team.getOwnerId())
                        .orElseThrow(UserNotFoundException::new))
                .build();
    }
}
