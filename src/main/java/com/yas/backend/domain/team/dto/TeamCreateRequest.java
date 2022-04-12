package com.yas.backend.domain.team.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record TeamCreateRequest(
        @Schema(description = "이름", example = "홍길동")
        @JsonProperty("name")
        String name,

        @Schema(description = "회원수")
        @JsonProperty("totalMemberCount")
        Integer totalMemberCount,

        @Schema(description = "설명")
        @JsonProperty("description")
        String description,

        @Schema(description = "해시태그", example = "개발스터디")
        @JsonProperty("hashtags")
        List<String> hashtags,

        @Schema(description = "기술스택", example = "[\"Spring Boot\", \"JPA\"]")
        @JsonProperty("techStacks")
        List<String> techStacks,

        @Schema(description = "모임 유형", allowableValues = {"ONLINE", "OFFLINE"})
        @JsonProperty("meetingMethod")
        String meetingMethod,

        @Schema(description = "정기모임 정책")
        @JsonProperty("schedulePolicy")
        String meetingCycle,

        @Schema(description = "가입 요건")
        @JsonProperty("joinConditions")
        List<String> joinConditions
) {
}
