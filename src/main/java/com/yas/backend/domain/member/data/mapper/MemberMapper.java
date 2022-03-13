package com.yas.backend.domain.member.data.mapper;

import com.yas.backend.domain.member.data.Member;
import com.yas.backend.common.entity.MemberEntity;
import com.yas.backend.domain.member.data.response.MemberResponse;
import com.yas.backend.domain.member.data.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MemberMapper {
    public Member entityToDomain(MemberEntity entity) {
        return Member.builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .nickname(entity.getNickname())
                .birth(entity.getBirth())
                .careerStartAt(entity.getCareerStartAt())
                .build();
    }

    public MemberDto domainToDto(Member domain) {
        return MemberDto.builder()
                .email(domain.getEmail())
                .nickname(domain.getNickname())
                .years(LocalDate.now().getYear() - domain.getBirth().getYear())
                .careerYear(LocalDate.now().getYear() - domain.getCareerStartAt().getYear())
                .build();
    }

    public MemberResponse dtoToResponse(MemberDto dto) {
        return MemberResponse.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .birthYear(dto.getYears())
                .careerYear(dto.getCareerYear())
                .build();
    }

}
