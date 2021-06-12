package com.emrullah.assessment.getir.commerce.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.emrullah.assessment.getir.commerce")
@EntityScan(basePackages = "com.emrullah.assessment.getir.commerce.entity")
@EnableJpaRepositories(basePackages = "com.emrullah.assessment.getir.commerce.repository")
@EnableAutoConfiguration
public class CommerceSpringApplication {
}
