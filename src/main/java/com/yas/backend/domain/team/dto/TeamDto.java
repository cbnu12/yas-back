package com.yas.backend.domain.team.dto;

import java.time.LocalDateTime;
import java.util.List;

public record TeamDto (
        Long id,
        String name,
        String meetingMethod,
        Integer totalMemberCount,
        String description,
        Long ownerId,
        List<Long> memberIds,
        List<String> hashtags,
        List<String> techStacks,
        List<String> joiningCondition,
        String schedulePolicy,
        List<LocalDateTime> meetingSchedules,
        LocalDateTime createdAt
) {}
