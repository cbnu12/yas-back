package com.yas.backend.domain.join.exchange;

import com.yas.backend.domain.join.dto.JoinDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class JoinsSearchResponse {
    private Long totalCount;
    private Long pageSize;
    private Long currentPage;
    private List<JoinSearchResponse> joinList;

    public static JoinsSearchResponse of(Page<JoinDto> result) {
        return JoinsSearchResponse.builder()
                .totalCount(result.getTotalElements())
                .pageSize((long) result.getSize())
                .currentPage((long) result.getNumber())
                .joinList(result.getContent().stream().map(JoinSearchResponse::of).toList())
                .build();
    }
}
