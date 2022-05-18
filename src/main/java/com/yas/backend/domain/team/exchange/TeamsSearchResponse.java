package com.yas.backend.domain.team.exchange;

import com.yas.backend.domain.team.dto.TeamDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class TeamsSearchResponse {

    private Long totalCount;
    private Long pageSize;
    private Long currentPage;
    private List<TeamSearchResponse> teamList;

    public static TeamsSearchResponse of(Page<TeamDto> result) {
        return TeamsSearchResponse.builder()
                .totalCount(result.getTotalElements())
                .pageSize((long) result.getSize())
                .currentPage((long) result.getNumber())
                .teamList(result.getContent().stream().map(TeamSearchResponse::of).toList())
                .build();
    }
}
