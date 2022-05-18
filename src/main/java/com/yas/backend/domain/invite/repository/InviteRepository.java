package com.yas.backend.domain.invite.repository;

import com.yas.backend.common.entity.InviteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteRepository extends JpaRepository<InviteEntity, Long> {
}
