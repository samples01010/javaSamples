package ru.dmitriy.demos.pandemic.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${swagger.serverUrl}")
    private String server;

    @Value("${swagger.authorEmail}")
    private String authorEmail;

    @Value("${swagger.authorUrl}")
    private String authorUrl;

    @Value("${swagger.authorName}")
    private String authorName;

    @Value("${swagger.appTitle}")
    private String appTitle;

    @Value("${swagger.appVersion}")
    private String appVersion;

    @Bean
    public OpenAPI customOpenAPI() {

        Contact swaggerContact = new Contact()
                .email(authorEmail)
                .url(authorUrl)
                .name(authorName);

        Info swaggerInfo = new Info()
                .title(appTitle)
                .version(appVersion)
                .contact(swaggerContact);

        Server swaggerServer = new Server()
                .url(server);

        return new OpenAPI()
                .addServersItem(swaggerServer)
                .info(swaggerInfo);

    }

}
