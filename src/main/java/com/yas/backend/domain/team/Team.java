package com.yas.backend.domain.team;

import com.yas.backend.common.enums.MeetingMethod;

import java.time.LocalDateTime;
import java.util.List;

public class Team {

    private Long id;
    private String name;
    private Long totalMemberCount;
    private List<String> hashtags;
    private List<String> techStacks;
    private MeetingMethod meetingMethod;
    private String description;
    private List<LocalDateTime> regularMeetingSchedules;
    private List<String> joiningCondition;
    private Long ownerId;
}
