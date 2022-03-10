package com.yas.backend.domain.member.data.mapper;

import com.yas.backend.domain.member.data.Member;
import com.yas.backend.domain.member.data.entity.MemberEntity;
import com.yas.backend.domain.member.data.response.MemberResponse;
import com.yas.backend.domain.member.data.dto.MemberDto;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member entityToDomain(MemberEntity entity) {
        return Member.builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .nickname(entity.getNickname())
                .birthYear(entity.getBirthYear())
                .careerYear(entity.getCareerYear())
                .build();
    }

    public MemberDto domainToDto(Member domain) {
        return MemberDto.builder()
                .email(domain.getEmail())
                .nickname(domain.getNickname())
                .birthYear(domain.getBirthYear())
                .careerYear(domain.getCareerYear())
                .build();
    }

    public MemberResponse dtoToResponse(MemberDto dto) {
        return MemberResponse.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .birthYear(dto.getBirthYear())
                .careerYear(dto.getCareerYear())
                .build();
    }

}