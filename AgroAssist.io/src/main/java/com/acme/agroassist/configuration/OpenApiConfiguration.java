package com.acme.agroassist.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfiguration {
    @Bean(name = "agroAssistOpenApi")
    public OpenAPI agroAssistOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("AgroAssist.io Application Api")
                        .description("AgroAssist.io API implemented with Spring Boot RESTful service and documented using spingdoc_openapi and OpenAPI 3.0"));
    }

}
