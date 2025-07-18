package com.innovyze.aquaservice.platform.u202311334.shared.infrastructure.persistence.jpa.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AquaResponse-Platform-Innovyze-API")
                        .version("1.0.0")
                        .description("RESTful API for AquaResponse.")
                );
    }
}