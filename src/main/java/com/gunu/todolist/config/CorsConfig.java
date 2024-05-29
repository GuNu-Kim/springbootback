package com.gunu.todolist.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                //.allowCredentials(true) //Cookie 전송
                .allowedOriginPatterns("*") //내보낼 원본 도메인 설정 springBoot2.4.4 이하 버전은 .allowedOrigins("*") 사용
                //.allowedMethods(new String[]{"GET","POST","PUT","DELETE"})  //요청방식
                .allowedMethods("*")  //요청방식 모두 허용
                .allowedHeaders("*")    //원본요청 헤더 내보내기
                .exposedHeaders("*");   //원본요청 헤더 정보 노출

        /*
        corsRegistry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*");
        */
    }
}
