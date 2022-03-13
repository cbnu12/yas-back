package com.yas.backend.domain.team;

import com.yas.backend.common.enums.MeetingMethod;
import com.yas.backend.common.values.Schedule;
import com.yas.backend.common.values.SchedulePolicy;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Team {

    private Long id;
    private String name;
    private MeetingMethod meetingMethod;
    private Integer totalMemberCount;
    private String description;
    private Long ownerId;
    private List<Long> memberIds;
    private List<String> hashtags;
    private List<String> techStacks;
    private List<String> joiningCondition;
    private SchedulePolicy schedulePolicy;
    private List<Schedule> meetingSchedules;
    private LocalDateTime createdAt;
}
