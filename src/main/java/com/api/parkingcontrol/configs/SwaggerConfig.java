package com.api.parkingcontrol.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contact() {
        return new Contact(
                "Leonardo Santos",
                "https://github.com/leonardosantos1",
                "leonardo.santos574@hotmail.com");
    }
    private ApiInfoBuilder apiInformations() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Parking Controll Rest API");
        apiInfoBuilder.description("Springboot REST API of Parking Controll");
        apiInfoBuilder.version("1.0");
        //apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        //apiInfoBuilder.license("Licença - Sua Empresa");
        //apiInfoBuilder.licenseUrl("http://www.seusite.com.br");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;

    }

    @Bean
    public Docket apiDetails() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.parkingcontrol.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInformations().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }

}
