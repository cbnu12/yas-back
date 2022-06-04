package com.yas.backend.domain.invitation.service.applicationservice;

import com.yas.backend.common.enums.ErrorType;
import com.yas.backend.common.exception.InvitationAlreadyExistException;
import com.yas.backend.common.exception.YasDomainValidationException;
import com.yas.backend.domain.invitation.Invitation;
import com.yas.backend.domain.invitation.mapper.InvitationMapper;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import com.yas.backend.domain.invitation.service.InvitationService;
import com.yas.backend.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
            return invitationService.save(invitationMapper.domainToDto(invitation)).getId();

        } catch (InvitationAlreadyExistException e) {
            log.info(e.getMessage());
            throw new YasDomainValidationException(ErrorType.JOIN_ALREADY_EXIST.getMessage());
        }
    }

    public void updateStatus(InvitationDto invitationDto) {
        Invitation invitation = Invitation.create(invitationService.findById(invitationDto.getId()));
        invitation.setStatus(invitationDto.getStatus());
        invitation.setUpdatedAt(LocalDateTime.now());
        invitationService.save(invitationMapper.domainToDto(invitation));
    }
}
