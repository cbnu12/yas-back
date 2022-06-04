package com.yas.backend.domain.invitation;

import com.yas.backend.common.enums.InvitationStatus;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Builder
public class Invitation {
    private Long id;
    private Long userId;
    private Long teamId;
    private Boolean isAlive;
    private InvitationStatus status;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;

    public static Invitation create(InvitationDto dto) {
        return Invitation.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .teamId(dto.getTeamId())
                .isAlive(Boolean.TRUE)
                .status(InvitationStatus.REQUEST)
                .createdBy(dto.getCreatedBy())
                .createdAt(dto.getCreatedAt())
                .build();

    }

    public void setStatus(InvitationStatus status) {
        this.status = status;
    }

    public void removeInvitation(Boolean isAlive) {
        this.isAlive = isAlive;
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

