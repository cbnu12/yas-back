package com.yas.backend;

import com.yas.backend.config.session.UserSession;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "API Demo", description = "demo 기능 정의")
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ApiController {

    private final UserSession userSession;

    @GetMapping()
    public String hello() {
        log.info("userSession => {}", userSession);
        return "Hello";
    }
}
