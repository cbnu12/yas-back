package com.yas.backend.domain.join;

import com.yas.backend.common.enums.JoinStatus;
import com.yas.backend.domain.join.dto.JoinDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

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

    private static Join create(JoinDto joinDto) {
        return Join.builder()
                .id(joinDto.getId())
                .userId(joinDto.getUserId())
                .teamId(joinDto.getTeamId())
                .isAlive(joinDto.getIsAlive())
                .status(joinDto.getStatus())
                .createdBy(joinDto.getCreatedBy())
                .createdAt(joinDto.getCreatedAt())
                .build();

    }

    public static Join createForOwner(JoinDto joinDto) {
        Join result = Join.create(joinDto);
        result.setStatus(JoinStatus.ACCEPT);
        result.activate();
        return result;
    }

    public static Join createAsRequest(JoinDto joinDto) {
        Join result = Join.create(joinDto);
        result.setStatus(JoinStatus.REQUEST);
        result.activate();
        return result;
    }

    public void setStatus(JoinStatus status) {
        this.status = status;
    }

    public void quit() {
        deactivate();
        this.status = JoinStatus.QUIT;
    }

    public void deactivate() {
        this.isAlive = Boolean.FALSE;
    }

    public void activate() {
        this.isAlive = Boolean.TRUE;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
