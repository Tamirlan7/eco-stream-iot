package com.tami.deviceservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI deviceServiceApiDocs() {
        return new OpenAPI()
                .info(new Info()
                        .title("Device Service API")
                        .description("Device service API for Energy Tracker App")
                        .contact(getContact())
                        .license(getLicense())
                        .version("1.0.0")
                );
    }

    private static Contact getContact() {
        Contact c = new Contact();
        c.setUrl("https://tami.com");
        c.setEmail("by.tami@gmail.com");
        return c;
    }

    private static License getLicense() {
        License l = new License();
        l.setUrl("https://tami.com");
        l.setName("Creative Commons Attribution-NonCommercial 4.0 International License");
        return l;
    }

}