package com.yas.backend.domain.member.repository;

import com.yas.backend.common.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
//    MemberEntity findByEmail(String email);
//    MemberEntity findAllByShowBirthYear(boolean showBirthYear);
}
