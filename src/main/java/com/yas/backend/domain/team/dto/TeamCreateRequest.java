package com.yas.backend.domain.team.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record TeamCreateRequest(
    @JsonProperty("name") String name,
    @JsonProperty("totalMemberCount") Integer totalMemberCount,
    @JsonProperty("description") String description,
    @JsonProperty("hashtags") List<String> hashtags,
    @JsonProperty("techStacks") List<String> techStacks,
    @JsonProperty("meetingMethod") String meetingMethod,
    @JsonProperty("schedulePolicy") String meetingCycle,
    @JsonProperty("joinConditions") List<String> joinConditions
) {}
