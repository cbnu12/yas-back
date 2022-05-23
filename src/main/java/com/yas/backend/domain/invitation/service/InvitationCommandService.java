package com.yas.backend.domain.invitation.service;

import com.yas.backend.common.enums.InvitationStatus;
import com.yas.backend.common.exception.InvitationAlreadyExistException;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.invitation.Invitation;
import com.yas.backend.domain.invitation.data.mapper.InvitationMapper;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import com.yas.backend.domain.invitation.service.domainService.InvitationService;
import com.yas.backend.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvitationCommandService {
    private final InvitationMapper invitationMapper;
    private final InvitationService invitationService;

    private final UserMapper userMapper;

    public Long create(final InvitationDto invitationDto) {
        try {
            if (invitationService.isExist(invitationDto)) {
                throw new InvitationAlreadyExistException();
            }
            Invitation invitation = Invitation.create(invitationDto);
            invitation.setStatus(InvitationStatus.REQUEST);
            invitation.removeInvitation(true);
            invitation.setCreatedAt(LocalDateTime.now());
            return invitationService.save(invitationMapper.domainToDto(invitation)).getId();

        } catch (InvitationAlreadyExistException | UserNotFoundException | TeamNotFoundException e) {
            log.info(e.getMessage());
            throw new ValidationException();
        }
    }

    public void updateStatus(InvitationDto invitationDto) {
        Invitation invitation = Invitation.create(invitationService.findById(invitationDto.getId()));
        invitation.setStatus(invitationDto.getStatus());
        invitation.setUpdatedAt(LocalDateTime.now());
        invitationService.save(invitationMapper.domainToDto(invitation));
    }

    public void remove(Long invitationId) {
        Invitation invitation = Invitation.create(invitationService.findById(invitationId));

        invitation.removeInvitation(false);
        invitation.setUpdatedAt(LocalDateTime.now());
        invitationService.save(invitationMapper.domainToDto(invitation));

    }
}
