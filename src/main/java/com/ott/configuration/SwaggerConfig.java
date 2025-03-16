package com.ott.configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "My API Documentation",
        version = "1.0",
        description = "This is the Swagger documentation for My API"
))
public class SwaggerConfig {
    // No additional methods needed, configuration is handled by SpringDoc automatically
}