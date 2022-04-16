package com.yas.backend.domain.team.dto;

import java.time.LocalDateTime;
import java.util.List;

public record TeamDto (
        Long id,
        String name,
        String meetingMethod,
        Integer totalUserCount,
        String description,
        Long ownerId,
        List<Long> userIds,
        List<String> hashtags,
        List<String> techStacks,
        List<String> joiningCondition,
        String schedulePolicy,
        List<LocalDateTime> meetingSchedules,
        LocalDateTime createdAt
) {}
