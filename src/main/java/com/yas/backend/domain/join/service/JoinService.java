package com.yas.backend.domain.join.service;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.domain.join.data.mapper.JoinMapper;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.join.exchange.JoinResponse;
import com.yas.backend.domain.join.repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinMapper joinMapper;
    private final JoinRepository joinRepository;
    public JoinDto teamJoin(JoinDto joinDto){
        return joinMapper.entityToDto(joinRepository.save(joinMapper.dtoToEntity(joinDto)));
    }

    public JoinDto teamSecession(JoinDto joinDto){
        JoinEntity joinEntity=joinRepository.getById(joinDto.getId());
        joinEntity.setActive(false);
        joinEntity.setUpdatedAt(LocalDateTime.now());
        joinEntity.setUpdatedBy(joinDto.getUpdatedBy());

        return joinMapper.entityToDto(joinRepository.save(joinEntity));
    }
}
