package com.yas.backend.domain.invitation.service;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.entity.InvitationEntity;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.InvitationNotFoundException;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.invitation.mapper.InvitationMapper;
import com.yas.backend.domain.invitation.dto.InvitationDto;
import com.yas.backend.domain.invitation.repository.InvitationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class InvitationService {
    private final InvitationMapper invitationMapper;
    private final InvitationRepository invitationRepository;

    public InvitationDto save(InvitationDto invitationDto) throws UserNotFoundException, TeamNotFoundException {
        return invitationMapper.entityToDto(invitationRepository.save(invitationMapper.dtoToEntity(invitationDto)));
    }


    public InvitationDto findById(Long InvitationId) {
        return invitationMapper.entityToDto(invitationRepository.findById(InvitationId).orElseThrow(InvitationNotFoundException::new));
    }

    public Boolean isExist(InvitationDto invitationDto) {
        InvitationEntity invitationEntity = invitationMapper.dtoToEntity(invitationDto);
        UserEntity userEntity = invitationEntity.getUser();
        TeamEntity teamEntity = invitationEntity.getTeam();
        return invitationRepository.findByUserAndTeam(userEntity, teamEntity).isPresent();
    }

    public Page<InvitationEntity> findBypredicate(final BooleanBuilder invitationPredicate, final Pageable pageable) {
        return invitationRepository.findByPredicate(invitationPredicate, pageable);
    }


}
