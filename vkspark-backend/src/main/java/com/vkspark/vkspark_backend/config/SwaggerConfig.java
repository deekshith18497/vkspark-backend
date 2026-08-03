package com.vkspark.vkspark_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()

                .info(

                        new Info()

                                .title("VKSpark Backend API")

                                .version("1.0")

                                .description("BookMyShow Clone Backend APIs")

                );

    }

}