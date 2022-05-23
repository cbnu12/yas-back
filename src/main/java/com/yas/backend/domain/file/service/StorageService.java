package com.yas.backend.domain.file.service;

import com.yas.backend.common.exception.DirectoryCreateFailException;
import com.yas.backend.common.exception.FileCreateFailException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public interface StorageService {
    String store(MultipartFile file, String additionalPath, LocalDate destructionDate) throws DirectoryCreateFailException, FileCreateFailException;
    Resource loadAsResource(String filename);
}
