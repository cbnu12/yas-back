package com.yas.backend.domain.file.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.file.service.StorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Tag(name = "Files", description = "파일 API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class FileController extends BaseController {
    private final StorageService storageService;

    @PostMapping(value = "file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "파일 업로드", description = "Multipart/form")
    public String upload(@RequestBody MultipartFile file) {
        return this.storageService.store(file, "common", LocalDate.now().plusDays(5));
    }

    @GetMapping("file/{id}")
    @Operation(summary = "파일 다운로드")
    public ResponseEntity<Resource> download(@PathVariable("id") String id) {
        Resource file = this.storageService.loadAsResource(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=%s".formatted(file.getFilename()))
                .body(file);
    }
}
