package org.k3sexamples.configuration.rest;

import org.k3sexamples.configuration.dao.ConfigRepository;
import org.k3sexamples.configuration.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.k3sexamples.configuration.dao.entities")
@EnableJpaRepositories("org.k3sexamples.configuration.dao")

public class ConfigApplication {
    @Autowired
    protected ConfigRepository configRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "configuration-application");
        SpringApplication.run(ConfigApplication.class, args);
    }

    @Bean
    public ConfigService service(){
        return new ConfigService(configRepository);
    }
}
