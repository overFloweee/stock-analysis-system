package com.hjw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ServletComponentScan("com.hjw.Controller")
public class StockAnalysisSystemApplication implements WebMvcConfigurer
{

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**").allowedOrigins("http://localhost:7070").allowCredentials(true);
    }
    public static void main(String[] args)
    {
        SpringApplication.run(StockAnalysisSystemApplication.class, args);
    }

}
