package com.gcf.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class GcfProviderUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(GcfProviderUserApplication.class, args);
	}
}
