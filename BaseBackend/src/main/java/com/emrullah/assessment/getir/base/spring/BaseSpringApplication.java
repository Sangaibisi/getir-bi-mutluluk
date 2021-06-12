package com.emrullah.assessment.getir.base.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.emrullah.assessment.getir.base")
@EntityScan(basePackages = "com.emrullah.assessment.getir.base.entity")
@EnableWebMvc
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "com.emrullah.assessment.getir.base.repository")
public class BaseSpringApplication {
}
