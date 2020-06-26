package com.utn.PhoneLines;

import com.utn.PhoneLines.configuration.Swagger2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication
@Import(Swagger2Config.class)
public class RestApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
