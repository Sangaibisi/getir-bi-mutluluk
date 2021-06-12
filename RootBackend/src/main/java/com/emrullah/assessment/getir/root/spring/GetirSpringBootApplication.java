package com.emrullah.assessment.getir.root.spring;

import com.emrullah.assessment.getir.base.spring.BaseSpringApplication;
import com.emrullah.assessment.getir.commerce.spring.CommerceSpringApplication;
import com.emrullah.assessment.getir.controller.spring.ControllerSpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages="com.emrullah.assessment.getir")
@Import(value = {BaseSpringApplication.class, CommerceSpringApplication.class, ControllerSpringApplication.class})
public class GetirSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetirSpringBootApplication.class, args);
	}

}
