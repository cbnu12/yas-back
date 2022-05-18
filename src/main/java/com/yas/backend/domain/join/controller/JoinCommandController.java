package com.yas.backend.domain.join.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.join.data.mapper.JoinMapper;
import com.yas.backend.domain.join.exchange.*;
import com.yas.backend.domain.join.service.JoinCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JoinCommandController extends BaseController {
    private final JoinCommandService joinCommandService;
    private final JoinMapper joinMapper;


    @PostMapping(value = "/team/join")
    public JoinCreateResponse createJoin(@RequestBody final JoinCreateRequest request){
        return JoinCreateResponse.of(joinCommandService.create(request.toDto()));
    }

    @PatchMapping(value = "/team/join/{joinId}/status")
    public JoinAnswerResponse answerJoin(@RequestBody final JoinAnswerRequest request,@PathVariable("joinId") Long joinId){
        return JoinAnswerResponse.of(joinCommandService.updateStatus(request.toDto(joinId)));
    }

    @DeleteMapping(value = "/team/join/{joinId}/status")
    public JoinDeleteResponse deleteJoin(@PathVariable ("joinId") Long joinId){
        return JoinDeleteResponse.of(joinCommandService.remove(joinId));
    }
}
