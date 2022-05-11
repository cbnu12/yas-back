package com.yas.backend.domain.techstack.repository;

import com.yas.backend.common.entity.TechStackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechstackRepository extends JpaRepository<TechStackEntity, Long> {
    Optional<TechStackEntity> findByName(String name);
}
