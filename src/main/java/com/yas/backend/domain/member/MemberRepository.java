package com.yas.backend.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    MemberEntity findByEmail(String email);
    MemberEntity findAllByShowBirthYear(boolean showBirthYear);
}
