package com.emrullah.assessment.getir.base.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.emrullah.assessment.getir.base")
@EnableWebMvc
@EnableAutoConfiguration
public class BaseSpringApplication {
}
