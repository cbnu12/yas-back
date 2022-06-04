package com.yas.backend.domain.invitation.controller;

import com.yas.backend.domain.invitation.exchange.InvitationSearchRequest;
import com.yas.backend.domain.invitation.exchange.InvitationsSearchResponse;
import com.yas.backend.domain.invitation.service.applicationservice.InvitationSearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Invitations", description = "가입 query API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class InvitationQueryController {
    private final InvitationSearchService invitationSearchService;

    @GetMapping("invitations")
    public InvitationsSearchResponse getInvitations(final InvitationSearchRequest invitationSearchRequest, final Pageable pageable) {
        return InvitationsSearchResponse.of(invitationSearchService.getInvitations(invitationSearchRequest, pageable));
    }

}
