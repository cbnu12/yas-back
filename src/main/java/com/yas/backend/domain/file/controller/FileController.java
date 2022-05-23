package com.yas.backend.domain.file.controller;

import com.yas.backend.common.controller.BaseController;
import com.yas.backend.domain.file.service.StorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Files", description = "파일 API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class FileController extends BaseController {
    private final StorageService storageService;
}
