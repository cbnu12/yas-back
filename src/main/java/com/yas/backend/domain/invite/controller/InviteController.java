package com.yas.backend.domain.invite.controller;

import com.yas.backend.domain.invite.mapper.InviteMapper;
import com.yas.backend.domain.invite.exchange.InviteRequest;
import com.yas.backend.domain.invite.exchange.InviteResponse;
import com.yas.backend.domain.invite.service.InviteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InviteController {
    private final InviteService inviteService;
    private final InviteMapper inviteMapper;

    @PostMapping("invite")
    public InviteResponse teamInvite(@RequestBody InviteRequest inviteRequest) {
        return inviteMapper.dtoToResponse(inviteService.teamInvite(inviteRequest.toDto()));
    }
}
