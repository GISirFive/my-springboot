package com.qianxin.grpc.config;

import com.qianxin.grpc.autoconfig.GlobalServerInterceptorConfigurerAdapter;
import com.qianxin.grpc.autoconfig.GlobalServerInterceptorRegistry;
import com.qianxin.grpc.interceptor.LogGrpcInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalInterceptorConfig {

    @Bean
    public GlobalServerInterceptorConfigurerAdapter globalInterceptorConfigurerAdapter() {
        return new GlobalServerInterceptorConfigurerAdapter() {
            @Override
            public void addServerInterceptors(GlobalServerInterceptorRegistry registry) {
                registry.addServerInterceptors(new LogGrpcInterceptor());
            }
        };
    }

}