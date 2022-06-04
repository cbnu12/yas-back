package com.yas.backend.domain.invitation.controller;

import com.yas.backend.domain.invitation.mapper.InvitationMapper;
import com.yas.backend.domain.invitation.exchange.InvitationAnswerRequest;
import com.yas.backend.domain.invitation.exchange.InvitationCreateRequest;
import com.yas.backend.domain.invitation.service.applicationservice.InvitationCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InvitationCommandController {
    private final InvitationCommandService invitationCommandService;
    private final InvitationMapper invitationMapper;

    @PostMapping("invitation")
    public void invite(@RequestBody InvitationCreateRequest invitationRequest) {
        invitationCommandService.create(invitationRequest.toDto());
    }
    
    @PatchMapping(value = "/invitaion/{invitationId}/status")
    public void answerJoin(@RequestBody final InvitationAnswerRequest request, @PathVariable("invitationId") Long invitationId) {
        invitationCommandService.updateStatus(request.toDto(invitationId));
    }

    @DeleteMapping(value = "/invitation/{invitationId}")
    public void deleteInvitation(@PathVariable("invitationId") Long invitationId) {
        invitationCommandService.updateStatus(invitationId);
    }
}
