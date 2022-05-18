package com.yas.backend.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion) {
        Info info = new Info().title("Yas API").version(appVersion)
                .description("Spring Boot 기반 Yas API")
                .contact(new Contact().name("강성조").url("강성조@yas.com"))
                .license(new License().name("Apache License"));

        SecurityScheme xUserIdScheme = new SecurityScheme().type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.HEADER).name("X-USER-ID");
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("X-USER-ID");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("X-USER-ID", xUserIdScheme))
                .security(List.of(securityRequirement))
                .info(info);
    }
}
