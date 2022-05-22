package com.yas.backend.domain.join.service.applicationservice;

import com.yas.backend.common.exception.JoinAlreadyExistException;
import com.yas.backend.common.exception.TeamNotFoundException;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.common.exception.YasDomainValidationException;
import com.yas.backend.domain.join.Join;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.join.mapper.JoinMapper;
import com.yas.backend.domain.join.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinCommandService {
    private final JoinMapper joinMapper;
    private final JoinService joinService;

    @Transactional
    public Long create(final JoinDto joinDto) {
        try {
            if (joinService.isExist(joinDto)) {
                throw new JoinAlreadyExistException();
            }

            Join join = Join.createAsRequest(joinDto);

            return joinService.save(joinMapper.domainToDto(join)).getId();

        } catch (JoinAlreadyExistException | UserNotFoundException | TeamNotFoundException e) {
            log.info(e.getMessage());
            throw new YasDomainValidationException(e.getMessage());
        }
    }

    @Transactional
    public void updateStatus(JoinDto joinDto) {
        Join join = joinMapper.dtoToDomain(joinService.findById(joinDto.getId()));
        join.setStatus(joinDto.getStatus());
        joinService.save(joinMapper.domainToDto(join));
    }

    @Transactional
    public void remove(Long joinId) {
        Join join = joinMapper.dtoToDomain(joinService.findById(joinId));
        join.quit();
        joinService.save(joinMapper.domainToDto(join));

    }
}
