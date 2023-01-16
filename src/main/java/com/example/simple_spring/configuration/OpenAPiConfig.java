package com.example.simple_spring.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "KnowledgeRepo API", version = "v1"))

public class OpenAPiConfig {
}
