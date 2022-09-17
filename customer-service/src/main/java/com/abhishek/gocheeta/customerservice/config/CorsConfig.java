package com.abhishek.gocheeta.customerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-18
 * Time: 00:49
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedHeaders("*");
//            }
//        };
//    }
}
