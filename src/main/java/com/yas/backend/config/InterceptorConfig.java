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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userSessionInterceptor)
                .excludePathPatterns("/swagger-ui/**")
                .excludePathPatterns("/api-docs/**")
                .addPathPatterns("/**");
    }
}
