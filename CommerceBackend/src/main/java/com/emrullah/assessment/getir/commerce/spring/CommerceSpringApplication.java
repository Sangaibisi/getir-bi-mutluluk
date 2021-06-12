package com.emrullah.assessment.getir.commerce.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.emrullah.assessment.getir.commerce")
@EntityScan(basePackages = "com.emrullah.assessment.getir.commerce.entity")
@EnableAutoConfiguration
public class CommerceSpringApplication {
}
