package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // Server configuration
        Server server = new Server();
        server.setUrl("https://9112.pro604cr.amypo.ai");
        server.setDescription("Production Server");

        // Security scheme for JWT
        SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .description("Enter JWT token");

        return new OpenAPI()
                .info(new Info()
                        .title("JWT Demo API")
                        .version("1.0")
                        .description("Simple JWT Demo Project for Students"))
                .servers(List.of(server))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", bearerAuth));
    }
}
