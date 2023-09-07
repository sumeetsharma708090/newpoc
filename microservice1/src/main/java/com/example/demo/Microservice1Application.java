package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.elastic.apm.attach.ElasticApmAttacher;

@SpringBootApplication
public class Microservice1Application {

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(Microservice1Application.class, args);
	}

}
