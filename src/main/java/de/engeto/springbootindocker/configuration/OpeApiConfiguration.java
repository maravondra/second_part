package de.engeto.springbootindocker.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpeApiConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("AIS - Book manager")
                        .description("This is the swagger for the book")
                )
                .servers(
                        List.of(
                             new Server()
                                     .url("localhost.cz")
                                     .description("Develop server")
                            ,
                            new Server()
                                    .url("{protocol}://sas.prota.com:{port}")
                                    .variables(
                                            new ServerVariables()
                                                    .addServerVariable("protocol",
                                                            new ServerVariable()
                                                                    ._default("https")
                                                                    .addEnumItem("https")
                                                                    .addEnumItem("http"))
                                                    .addServerVariable("port",
                                                            new ServerVariable()
                                                                    ._default("8080")
                                                                    .description("Port on which is the application running"))
                                    )
                        )

                );
    }

}
