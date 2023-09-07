package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import co.elastic.apm.attach.ElasticApmAttacher;

@SpringBootApplication
public class Microservice3Application {

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(Microservice3Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
