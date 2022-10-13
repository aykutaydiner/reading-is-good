package com.getir.readingisgood.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.getir.readingisgood.repository")
public class JpaConfig {

}
