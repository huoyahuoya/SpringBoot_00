package com.example.demo_2020_1211.MyAnnotations.case_three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan
public class MyAnnotionInterceptorConfig extends WebMvcConfigurationSupport {
    //注入自定义的拦截器
    @Autowired
    private MyAnnotionInterceptor myAnnotionInterceptor;

    //注册拦截器并定义拦截路由
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myAnnotionInterceptor).addPathPatterns("/testMyselfAnno/**");
        super.addInterceptors(registry);
    }
}
