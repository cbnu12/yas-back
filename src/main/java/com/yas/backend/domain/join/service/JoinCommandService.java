package com.yas.backend.domain.join.service;

import com.yas.backend.common.enums.JoinStatus;
import com.yas.backend.common.exception.JoinAlreadyExistException;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.join.Join;
import com.yas.backend.domain.join.data.mapper.JoinMapper;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.join.service.domainservice.JoinService;
import com.yas.backend.domain.team.dto.TeamDto;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinCommandService {
    private final JoinMapper joinMapper;
    private final JoinService joinService;

    private final UserMapper userMapper;

    public Long create(final JoinDto joinDto){
        try {
            if(joinService.isExist(joinDto)){
                throw new JoinAlreadyExistException();
            }
            Join join= Join.create(joinDto);
            join.setStatus(JoinStatus.REQUEST);
            join.setIsAlive(true);
            return joinService.save(joinMapper.domainToDto(join)).getId();

        }catch (JoinAlreadyExistException | UserNotFoundException |TeamNotFoundException e){
            log.info(e.getMessage());
            throw new ValidationException();
        }
    }

    public long updateStatus(JoinDto joinDto){
        Join join= Join.create(joinService.findById(joinDto.getId()));
        join.setStatus(joinDto.getStatus());
        return joinService.update(joinMapper.domainToDto(join)).getId();
    }

    public Long remove(Long joinId){
        Join join= Join.create(joinService.findById(joinId));
        join.setStatus(JoinStatus.EXIT);
        join.setIsAlive(false);
        return joinService.update(joinMapper.domainToDto(join)).getId();

    }
}
