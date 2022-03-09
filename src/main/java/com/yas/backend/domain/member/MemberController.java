package com.yas.backend.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/members")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;
    @GetMapping
    public List<MemberResponse> findAllActiveMember() {
        return memberService.findAllActiveMember().stream().map(memberMapper::dtoToResponse).toList();
    }
}
