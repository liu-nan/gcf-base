package com.gcf.provider.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GcfProviderPermissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcfProviderPermissionApplication.class, args);
	}
}
