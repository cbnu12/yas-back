package com.yas.backend.domain.join.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.join.exchange.JoinAnswerRequest;
import com.yas.backend.domain.join.exchange.JoinCreateRequest;
import com.yas.backend.domain.join.exchange.JoinCreateResponse;
import com.yas.backend.domain.join.service.applicationservice.JoinCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JoinCommandController extends BaseController {
    private final JoinCommandService joinCommandService;

    @PostMapping(value = "/team/join")
    public JoinCreateResponse createJoin(@RequestBody final JoinCreateRequest request) {
        return JoinCreateResponse.of(joinCommandService.create(request.toDto()));
    }

    @PatchMapping(value = "/team/join/{joinId}/status")
    public void answerJoin(@RequestBody final JoinAnswerRequest request, @PathVariable("joinId") Long joinId) {
        joinCommandService.updateStatus(request.toDto(joinId));
    }

    @DeleteMapping(value = "/team/join/{joinId}")
    public void deleteJoin(@PathVariable("joinId") Long joinId) {
        joinCommandService.remove(joinId);
    }
}
