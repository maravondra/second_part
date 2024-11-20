package de.engeto.springbootindocker.configuration;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpeApiConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("AIS ")
                        .description("This is try project")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"))
                        .contact(new Contact().name("API Support").url("http://example.com/contact").email("support@example.com")))
                .servers(List.of(
                        new Server().url("{protocol}://{customerId}.saas-app.com:{port}/v2").description("Test server")
                                .variables(new ServerVariables()
                                        .addServerVariable("customerId",
                                                new ServerVariable()
                                                        ._default("demo")
                                                        .description("Customer ID assigned by the service provider"))
                                        .addServerVariable("protocol",
                                                new ServerVariable()
                                                        ._default("https")
                                                        .addEnumItem("http")
                                                        .addEnumItem("https"))
                                        .addServerVariable("port",
                                                new ServerVariable()
                                                        ._default("443")
                                                        .addEnumItem("443")
                                                        .addEnumItem("8443")))   ,
                        new Server().url("https://production.com").description("Production Server")))
                .externalDocs(new ExternalDocumentation()
                        .description("Find more info here")
                        .url("http://example.com/docs"))
                .components(new Components().addSecuritySchemes("bearerAuth", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
                .tags(List.of(new Tag().name("Authentication").description("Operations related to authentication")));
    }

}
