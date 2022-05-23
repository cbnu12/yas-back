package com.yas.backend.domain.join.service.domainservice;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.domain.join.data.mapper.JoinMapper;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.join.dto.JoinPredicate;
import com.yas.backend.domain.join.exchange.JoinSearchRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinSearchService {
    private final JoinMapper joinMapper;
    private final JoinService joinService;

    public Page<JoinDto> getJoins(final JoinSearchRequest joinSearchRequest, final Pageable pageable) {
        BooleanBuilder joinPredicate = JoinPredicate.joinPredicate(joinSearchRequest);
        return joinService.findBypredicate(joinPredicate, pageable)
                .map(joinMapper::entityToDto);
    }

}
