package com.getir.readingisgood.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.getir.readingisgood")
@EntityScan(basePackages = "com.getir.readingisgood.domain.entity")
public class ReadingIsGoodConfig {

}
