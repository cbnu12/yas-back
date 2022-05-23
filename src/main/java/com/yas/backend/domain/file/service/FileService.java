package com.yas.backend.domain.file.service;

import com.yas.backend.common.entity.FileEntity;
import com.yas.backend.common.exception.DirectoryCreateFailException;
import com.yas.backend.common.exception.FileCreateFailException;
import com.yas.backend.domain.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService implements StorageService {
    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    private final FileRepository fileRepository;

    @Override
    public String store(MultipartFile file, String additionalPath, LocalDate destructionDate) throws DirectoryCreateFailException, FileCreateFailException {
        String id = UUID.randomUUID().toString();
        Path saveDirectory = Paths.get(this.uploadPath, additionalPath);
        try {
            Files.createDirectories(saveDirectory);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DirectoryCreateFailException();
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, saveDirectory.resolve(id));
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileCreateFailException();
        }

        FileEntity fileEntity = FileEntity.builder()
                .id(id)
                .filePath(Paths.get(saveDirectory.toString(), id).toString())
                .originalFilename(file.getOriginalFilename())
                .destructionDate(destructionDate)
                .build();

        return this.fileRepository.save(fileEntity).getId();
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }
}
