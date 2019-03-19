package com.lenovo.operation.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SessionConfiguration implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludes = new String[]{"/","/user/login","/static/**"};
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**").excludePathPatterns(excludes);
    }
}
