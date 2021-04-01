package com.gcf.provider.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class GcfProviderContentApplication {
	public static void main(String[] args) {
		SpringApplication.run(GcfProviderContentApplication.class, args);
	}
}
