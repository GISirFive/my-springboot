package com.qianxin.grpc.config;

import com.qianxin.grpc.autoconfig.GlobalClientInterceptorConfigurerAdapter;
import com.qianxin.grpc.autoconfig.GlobalClientInterceptorRegistry;
import com.qianxin.grpc.interceptor.LogGrpcInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE)
@Configuration
public class GlobalClientInterceptorConfig {

    @Bean
    public GlobalClientInterceptorConfigurerAdapter globalInterceptorConfigurerAdapter() {
        return new GlobalClientInterceptorConfigurerAdapter() {

            @Override
            public void addClientInterceptors(GlobalClientInterceptorRegistry registry) {
                registry.addClientInterceptors(new LogGrpcInterceptor());
            }
        };
    }

}