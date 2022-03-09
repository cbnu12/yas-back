package com.yas.backend.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public List<MemberDto> findAllActiveMember() {
        List<Member> members = memberRepository.findAll().stream()
                .filter(MemberEntity::isActive)
                .map(memberMapper::entityToDomain)
                .toList();

        return members.stream().map(memberMapper::domainToDto).toList();
    }
}
