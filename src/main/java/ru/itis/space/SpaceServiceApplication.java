package ru.itis.space;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "ru.itis.space")
@EnableJpaRepositories(basePackages = "ru.itis.space.repositories")
@EntityScan(basePackages = "ru.itis.space.entires.models")
public class SpaceServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpaceServiceApplication.class);
    }

}
