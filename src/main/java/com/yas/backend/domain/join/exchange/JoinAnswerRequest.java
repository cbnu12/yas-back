package com.yas.backend.domain.join.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yas.backend.common.enums.JoinStatus;
import com.yas.backend.domain.join.dto.JoinDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinAnswerRequest {
    @Schema(description = "상태 REQUEST | ACCEPT | REJECT | QUIT | BAN")
    @JsonProperty("status")
    private String status;

    public JoinDto toDto(Long joinId) {
        return JoinDto.builder()
                .id(joinId)
                .status(JoinStatus.valueOf(status))
                .build();
    }
}
