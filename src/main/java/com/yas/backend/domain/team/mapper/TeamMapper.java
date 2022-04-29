package com.yas.backend.domain.team.mapper;

import com.yas.backend.common.entity.*;
import com.yas.backend.common.enums.MeetingMethod;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.common.values.Schedule;
import com.yas.backend.domain.team.Team;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    private final UserRepository userRepository;

    public Team dtoToDomain(final TeamDto teamDto) {
        return Team.builder()
                .id(teamDto.id())
                .name(teamDto.name())
                .meetingMethod(MeetingMethod.valueOf(teamDto.meetingMethod()))
                .totalUserCount(teamDto.totalUserCount())
                .description(teamDto.description())
                .ownerId(teamDto.ownerId())
                .userIds(teamDto.userIds())
                .hashtags(teamDto.hashtags())
                .techStacks(teamDto.techStacks())
                .joiningCondition(teamDto.joiningCondition())
                .createdAt(teamDto.createdAt())
                .build();
    }

    public TeamEntity dtoToEntity(final TeamDto teamDto) {
        return TeamEntity.builder()
                .id(teamDto.id())
                .name(teamDto.name())
                .meetingMethod(MeetingMethod.valueOf(teamDto.meetingMethod()))
                .totalUserCount(teamDto.totalUserCount())
                .description(teamDto.description())
                .owner(userRepository.findById(teamDto.ownerId())
                        .orElseThrow(UserNotFoundException::new))
                .build();
    }

    public TeamDto entityToDto(final TeamEntity teamEntity) {
        return new TeamDto(
                teamEntity.getId(),
                teamEntity.getName(),
                teamEntity.getMeetingMethod().name(),
                teamEntity.getTotalUserCount(),
                teamEntity.getDescription(),
                teamEntity.getOwner().getId(),
                teamEntity.getJoins().stream().map(JoinEntity::getUser).map(UserEntity::getId).toList(),
                teamEntity.getHashtags().stream().map(HashtagEntity::getName).toList(),
                teamEntity.getTechStacks().stream().map(TechStackEntity::getName).toList(),
                teamEntity.getJoiningConditions().stream().map(JoiningConditionEntity::getCondition).toList(),
                makeMeetingCycleToString(teamEntity.getSchedulePolicy()),
                teamEntity.getSchedules().stream().map(ScheduleEntity::getDateTime).toList(),
                teamEntity.getCreatedAt()
                );
    }


    public TeamDto domainToDto(Team team) {
        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getMeetingMethod().name(),
                team.getTotalUserCount(),
                team.getDescription(),
                team.getOwnerId(),
                team.getUserIds(),
                team.getHashtags(),
                team.getTechStacks(),
                team.getJoiningCondition(),
                team.getSchedulePolicy().toString(),
                team.getMeetingSchedules().stream().map(Schedule::getDateTime).toList(),
                team.getCreatedAt()
        );
    }

    private String makeMeetingCycleToString(SchedulePolicyEntity schedulePolicyEntity) {
        return schedulePolicyEntity.getMeetingCycle() + " "
                + schedulePolicyEntity.getTimes() + "회, "
                + DayOfWeek.of(schedulePolicyEntity.getDayOfWeek()).name();
    }
}
