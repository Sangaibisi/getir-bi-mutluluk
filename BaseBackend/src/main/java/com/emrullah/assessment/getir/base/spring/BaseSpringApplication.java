package com.emrullah.assessment.getir.base.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.emrullah.assessment.getir.base")
@EnableJpaRepositories(basePackages = "com.emrullah.assessment.getir.base.repository")
@EntityScan(basePackages = "com.emrullah.assessment.getir.base.entity")
@EnableJpaAuditing
@EnableWebMvc
@EnableAutoConfiguration
public class BaseSpringApplication {
}
