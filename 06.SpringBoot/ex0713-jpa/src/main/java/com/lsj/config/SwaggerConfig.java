package com.lsj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot 3 JPA API")
                        .description("JPA 학습용 REST API")
                        .version("1.0")
                        .contact(new Contact()
                                .name("LSJ")
                                .email("lsj001206@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("API Document"));
    }

}
