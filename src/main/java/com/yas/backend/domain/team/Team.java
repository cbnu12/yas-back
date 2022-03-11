package com.yas.backend.domain.team;

import com.yas.backend.common.enums.MeetingMethod;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<LocalDateTime> meetingSchedules;
    private List<String> joiningCondition;
}
