package com.yas.backend.domain.file.repository;

import com.yas.backend.common.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, String> {
}
