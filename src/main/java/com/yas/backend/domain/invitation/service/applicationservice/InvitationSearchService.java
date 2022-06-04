package com.yas.backend.domain.invitation.service.applicationservice;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.domain.invitation.mapper.InvitationMapper;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import com.yas.backend.domain.invitation.dto.InvitationPredicate;
import com.yas.backend.domain.invitation.exchange.InvitationSearchRequest;
import com.yas.backend.domain.invitation.service.InvitationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvitationSearchService {
    private final InvitationMapper invitationMapper;
    private final InvitationService invitationService;

    public Page<InvitationDto> getInvitations(final InvitationSearchRequest invitationSearchRequest, final Pageable pageable) {
        BooleanBuilder invitationPredicate = InvitationPredicate.invitationPredicate(invitationSearchRequest);
        return invitationService.findBypredicate(invitationPredicate, pageable)
                .map(invitationMapper::entityToDto);
    }

}
