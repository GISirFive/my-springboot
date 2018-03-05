package com.qianxin.web.config.mvc;

import com.qianxin.web.config.mvc.interceptor.AuthenticateInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry
                .addInterceptor(new AuthenticateInterceptor())
                .excludePathPatterns();
    }
}
