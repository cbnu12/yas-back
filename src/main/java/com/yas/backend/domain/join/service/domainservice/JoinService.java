package com.yas.backend.domain.join.service.domainservice;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.common.entity.TeamEntity;
import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.common.exception.JoinNotFoundException;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.join.data.mapper.JoinMapper;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.join.repository.JoinRepository;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.dto.UserDto;
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

    private final UserMapper userMapper;
    private final TeamMapper teamMapper;
    public JoinDto save(JoinDto joinDto) throws UserNotFoundException, TeamNotFoundException {
        return joinMapper.entityToDto(joinRepository.save(joinMapper.dtoToEntity(joinDto)));
    }


    public JoinDto findById(Long joinId){
        return joinMapper.entityToDto(joinRepository.findById(joinId).orElseThrow(JoinNotFoundException::new));
    }

    public Boolean isExist(JoinDto joinDto){
        JoinEntity joinEntity= joinMapper.dtoToEntity(joinDto);
        UserEntity userEntity= joinEntity.getUser();
        TeamEntity teamEntity= joinEntity.getTeam();
        return joinRepository.findByUserAndTeam(userEntity,teamEntity).isPresent();
    }


}
