package com.ayush.InterceptorDemo.config;

import com.ayush.InterceptorDemo.interceptor.AuthenticationInterceptor;
import com.ayush.InterceptorDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private LoggingInterceptor loggingInterceptor;
    private AuthenticationInterceptor authenticationInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor,
                     AuthenticationInterceptor authenticationInterceptor){
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(loggingInterceptor)
                .order(2)
                .addPathPatterns("/api/students/**");

        registry.addInterceptor(authenticationInterceptor)
                .order(1)
                .addPathPatterns("/api/*");     //single * means that only one / is allowed after /api

    }
}
