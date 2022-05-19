package com.yas.backend.domain.join.service;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.JoinNotFoundException;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.join.data.mapper.JoinMapper;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.join.repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinService {

    private final JoinMapper joinMapper;
    private final JoinRepository joinRepository;

    @Transactional
    public JoinDto save(JoinDto joinDto) throws UserNotFoundException, TeamNotFoundException {
        return joinMapper.entityToDto(joinRepository.save(joinMapper.dtoToEntity(joinDto)));
    }

    @Transactional
    public List<JoinDto> saveAll(List<JoinDto> joinDto) throws UserNotFoundException, TeamNotFoundException {
        return joinRepository.saveAll(joinDto.stream().map(joinMapper::dtoToEntity).toList()).stream()
                .map(joinMapper::entityToDto)
                .toList();
    }

    @Transactional
    public JoinDto create(JoinDto joinDto) {
        JoinEntity joinEntity = joinMapper.dtoToEntity(joinDto);
        return joinMapper.entityToDto(joinRepository.save(joinEntity));
    }

    public JoinDto findById(Long joinId) {
        return joinMapper.entityToDto(joinRepository.findById(joinId).orElseThrow(JoinNotFoundException::new));
    }

    public Boolean isExist(JoinDto joinDto) {
        JoinEntity joinEntity = joinMapper.dtoToEntity(joinDto);
        UserEntity userEntity = joinEntity.getUser();
        TeamEntity teamEntity = joinEntity.getTeam();
        return joinRepository.findByUserAndTeam(userEntity, teamEntity).isPresent();
    }

    public List<JoinDto> findByTeamId(Long teamId) {
        return joinRepository.findByTeamId(teamId).stream()
                .map(joinMapper::entityToDto)
                .toList();
    }
}
