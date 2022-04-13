package com.yas.backend;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "API Demo", description = "demo 기능 정의")
@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping()
    public String hello() {
        return "Hello";
    }
}
