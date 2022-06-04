package com.yas.backend.domain.invitation.dto;

import com.yas.backend.common.enums.InvitationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvitationDto {
    private Long id;
    private Long userId;
    private Long teamId;
    private String updatedBy;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private InvitationStatus status;
    private Boolean isAlive;
}
