package com.yas.backend.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class UserSessionConfig {

    @Bean
    @SessionScope
    public UserSession userSession() {
        return new UserSession();
    }
}
