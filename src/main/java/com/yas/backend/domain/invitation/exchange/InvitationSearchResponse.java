package com.yas.backend.domain.invitation.exchange;

import com.yas.backend.common.enums.InvitationStatus;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class InvitationSearchResponse {
    private Long id;
    private Long userId;
    private Long teamId;
    private String updatedBy;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private InvitationStatus status;
    private Boolean isAlive;

    public static InvitationSearchResponse of(InvitationDto dto) {
        return InvitationSearchResponse.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .teamId(dto.getTeamId())
                .updatedBy(dto.getUpdatedBy())
                .updatedAt(dto.getUpdatedAt())
                .createdBy(dto.getCreatedBy())
                .createdAt(dto.getCreatedAt())
                .status(dto.getStatus())
                .isAlive(dto.getIsAlive())
                .build();
    }
}
