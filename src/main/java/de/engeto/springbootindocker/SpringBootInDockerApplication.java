package de.engeto.springbootindocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SpringBootInDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInDockerApplication.class, args);
    }

}
