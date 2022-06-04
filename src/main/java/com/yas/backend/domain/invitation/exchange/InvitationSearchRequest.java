package com.yas.backend.domain.invitation.exchange;

import com.yas.backend.common.values.InvitationSearchType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class InvitationSearchRequest {
    private String status;
    private String teamName;
    private String userEmail;
    private InvitationSearchType searchType;
    private String sortType;


}
