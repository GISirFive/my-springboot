package com.qianxin.grpc.autoconfig;

import io.grpc.LoadBalancer;
import io.grpc.util.RoundRobinLoadBalancerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: Michael
 * Email: yidongnan@gmail.com
 * Date: 5/17/16
 */
@Configuration
@EnableConfigurationProperties
@ConditionalOnClass({GrpcChannelFactory.class})
public class GrpcClientAutoConfiguration {

    @ConditionalOnMissingBean
    @Bean
    public GrpcChannelsProperties grpcChannelsProperties() {
        return new GrpcChannelsProperties();
    }

    @Bean
    public GlobalClientInterceptorRegistry globalClientInterceptorRegistry() {
        return new GlobalClientInterceptorRegistry();
    }

    @ConditionalOnMissingBean
    @Bean
    public LoadBalancer.Factory grpcLoadBalancerFactory() {
        return RoundRobinLoadBalancerFactory.getInstance();
    }

    @ConditionalOnMissingBean(value = GrpcChannelFactory.class, type = "org.springframework.cloud.client.discovery.DiscoveryClient")
    @Bean
    public GrpcChannelFactory addressChannelFactory(GrpcChannelsProperties channels, LoadBalancer.Factory loadBalancerFactory, GlobalClientInterceptorRegistry globalClientInterceptorRegistry) {
        return new AddressChannelFactory(channels, loadBalancerFactory, globalClientInterceptorRegistry);
    }

    @Bean
    @ConditionalOnClass(GrpcClient.class)
    public GrpcClientBeanPostProcessor grpcClientBeanPostProcessor() {
        return new GrpcClientBeanPostProcessor();
    }

}
