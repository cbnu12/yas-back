package com.yas.backend.domain.invitation.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yas.backend.common.enums.InvitationStatus;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvitationAnswerRequest {
    @Schema(description = "상태 REQUEST | ACCEPT | REJECT")
    @JsonProperty("status")
    private String status;

    public InvitationDto toDto(Long invitationId) {
        return InvitationDto.builder()
                .id(invitationId)
                .status(InvitationStatus.valueOf(status))
                .build();
    }
}
