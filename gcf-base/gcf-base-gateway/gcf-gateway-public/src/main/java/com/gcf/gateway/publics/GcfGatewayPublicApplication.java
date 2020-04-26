package com.gcf.gateway.publics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GcfGatewayPublicApplication {
	public static void main(String[] args) {
		SpringApplication.run(GcfGatewayPublicApplication.class, args); 
	}
}
