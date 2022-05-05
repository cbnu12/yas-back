package com.yas.backend.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class UserSessionConfig {

    @Bean
    @RequestScope
    public UserSession userSession() {
        return new UserSession();
    }
}
