package com.bastos.aluraflix.config.swagger;

import com.bastos.aluraflix.dataprovider.repository.entity.UsuarioEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket aluraApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bastos.aluraflix"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .ignoredParameterTypes(UsuarioEntity.class)
                .globalOperationParameters(List.of(
                         new ParameterBuilder()
                                 .name("Authorization")
                                 .description("Header para token JWT")
                                 .modelRef(new ModelRef("string"))
                                 .parameterType("header")
                                 .required(false)
                         .build()));
    }
}
