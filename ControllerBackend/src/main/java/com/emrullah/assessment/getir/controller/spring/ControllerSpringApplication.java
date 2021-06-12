package com.emrullah.assessment.getir.controller.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.emrullah.assessment.getir.controller","com.emrullah.assessment.getir.controller.*"})
@EnableWebMvc
public class ControllerSpringApplication {
}
