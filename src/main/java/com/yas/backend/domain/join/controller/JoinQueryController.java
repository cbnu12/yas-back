package com.yas.backend.domain.join.controller;

import com.yas.backend.domain.join.exchange.JoinSearchRequest;
import com.yas.backend.domain.join.exchange.JoinsSearchResponse;
import com.yas.backend.domain.join.service.domainservice.JoinSearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Joins", description = "가입 query API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class JoinQueryController {
    private final JoinSearchService joinSearchService;

    @GetMapping("joins")
    public JoinsSearchResponse getJoins(final JoinSearchRequest joinSearchRequest, final Pageable pageable) {
        return JoinsSearchResponse.of(joinSearchService.getJoins(joinSearchRequest, pageable));
    }

}
