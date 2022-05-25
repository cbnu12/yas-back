package com.yas.backend.domain.invite.service;

import com.yas.backend.domain.invite.data.mapper.InviteMapper;
import com.yas.backend.domain.invite.dto.InviteDto;
import com.yas.backend.domain.invite.repository.InviteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class InviteService {
    private final InviteMapper inviteMapper;
    private final InviteRepository inviteRepository;

    public InviteDto teamInvite(InviteDto inviteDto) {
        return inviteMapper.entityToDto(inviteRepository.save(inviteMapper.dtoToEntity(inviteDto)));
    }

}
