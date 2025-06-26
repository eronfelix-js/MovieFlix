package com.felixDev.movieFliex.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenApi(){

        Contact contact = new Contact();
        contact.name("Eron felix");
        contact.email("Eronf5594@gmail.com");

        Info info = new Info();
        info.title("MovieFlix");
        info.version("V1");
        info.description("Api para gerenciamento de catalogo de filmes");
        info.contact(contact);

        return new OpenAPI().info(info);
    }

}
