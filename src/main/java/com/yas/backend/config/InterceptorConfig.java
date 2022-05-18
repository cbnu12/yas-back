package com.yas.backend.config;

import com.yas.backend.common.interceptor.UserSessionInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final UserSessionInterceptor userSessionInterceptor;
    public static final String X_USER_ID = "X-USER-ID";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userSessionInterceptor)
                .excludePathPatterns("/swagger-ui/**")
                .excludePathPatterns("/api-docs/**")
                .excludePathPatterns("/api/signUp")
                .excludePathPatterns("/api/auth/validation")
                .addPathPatterns("/**");
    }
}
