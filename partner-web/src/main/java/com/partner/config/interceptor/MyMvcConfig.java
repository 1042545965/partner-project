package com.partner.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //这里可以添加多个拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登陆拦截器
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/index/*", "/partnerBsMessage/*", "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/fonts/*");
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index/login")
//                .setViewName("login");
//    }

    /**
     *
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


}

