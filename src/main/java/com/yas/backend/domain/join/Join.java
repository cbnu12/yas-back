package com.yas.backend.domain.join;

import com.yas.backend.common.enums.JoinStatus;
import com.yas.backend.domain.join.dto.JoinDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Builder
public class Join {
    private Long id;
    private Long userId;
    private Long teamId;
    private Boolean isAlive;
    private JoinStatus status;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;

    public static Join create(JoinDto joinDto) {
        return Join.builder()
                .id(joinDto.getId())
                .userId(joinDto.getUserId())
                .teamId(joinDto.getTeamId())
                .isAlive(joinDto.getIsAlive())
                .status(joinDto.getStatus())
                .createdBy(joinDto.getCreatedBy())
                .createdAt(joinDto.getCreatedAt())
                .updatedBy(joinDto.getUpdatedBy())
                .updatedAt(joinDto.getUpdatedAt())
                .build();

    }

    public void setStatus(JoinStatus status) {
        this.status = status;
    }

    public void deactivate() {
        this.isAlive = Boolean.FALSE;
    }

    public void activate() {
        this.isAlive = Boolean.TRUE;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        updatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.updatedAt = updatedAt;
    }
}
