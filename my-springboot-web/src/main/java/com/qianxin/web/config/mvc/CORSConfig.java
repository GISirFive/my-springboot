package com.qianxin.web.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                //配置可以被跨域的路径, 可以任意配置, 可以具体到直接请求路径
                .addMapping("/**")
                //允许所有的请求方法访问该跨域资源服务器, 如POST PUT GET DELETE等
                .allowedMethods("*")
                //允许所有请求域名访问我们的跨域资源, 可以固定单条或者多条
                .allowedOrigins("*")
                //允许所有的Header访问, 可以自定义设置任意请求头信息, 如
                .allowedHeaders("*");
    }
}
