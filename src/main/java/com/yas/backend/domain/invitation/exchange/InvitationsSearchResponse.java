package com.yas.backend.domain.invitation.exchange;

import com.yas.backend.domain.invitation.dto.InvitationDto;
import com.yas.backend.domain.invitation.exchange.InvitationSearchResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class InvitationsSearchResponse {
    private Long totalCount;
    private Long pageSize;
    private Long currentPage;
    private List<InvitationSearchResponse> invitationList;

    public static com.yas.backend.domain.invitation.exchange.InvitationsSearchResponse of(Page<InvitationDto> result) {
        return com.yas.backend.domain.invitation.exchange.InvitationsSearchResponse.builder()
                .totalCount(result.getTotalElements())
                .pageSize((long) result.getSize())
                .currentPage((long) result.getNumber())
                .invitationList(result.getContent().stream().map(InvitationSearchResponse::of).toList())
                .build();
    }
}
