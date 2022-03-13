package com.yas.backend.domain.member.repository;

import com.yas.backend.common.entity.MemberEntity;
import com.yas.backend.domain.member.data.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {


    MemberEntity findByEmail(String email);
}
