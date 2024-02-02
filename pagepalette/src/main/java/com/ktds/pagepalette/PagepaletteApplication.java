package com.ktds.pagepalette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class PagepaletteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagepaletteApplication.class, args);
    }
}
