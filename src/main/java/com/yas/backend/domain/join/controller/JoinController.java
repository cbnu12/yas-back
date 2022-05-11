package com.yas.backend.domain.join.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.join.data.mapper.JoinMapper;
import com.yas.backend.domain.join.exchange.JoinRequest;
import com.yas.backend.domain.join.exchange.JoinResponse;
import com.yas.backend.domain.join.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JoinController extends BaseController {
    private final JoinService joinService;
    private final JoinMapper joinMapper;

    @PostMapping("join")
    public JoinResponse teamJoin(@RequestBody JoinRequest joinRequest){
        return joinMapper.dtoToResponse(joinService.teamJoin(joinRequest.toDto()));
    }

    @PutMapping("join")
    public JoinResponse teamSecession(@RequestBody JoinRequest joinRequest){
        return joinMapper.dtoToResponse(joinService.teamSecession(joinRequest.toDto()));
    }
}
