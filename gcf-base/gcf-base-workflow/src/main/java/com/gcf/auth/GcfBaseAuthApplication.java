package com.gcf.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GcfBaseAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(GcfBaseAuthApplication.class, args);
	}
}
