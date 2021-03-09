package com.gcf.gateway.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.gcf.common.constans.Constans;
import com.gcf.common.util.JwtUtil;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class GcfGatewayWebApplication {

	@Value("${spring.application.name}")
	private String appName;
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		RestTemplate temp = new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new ClientHttpRequestInterceptor() {
			
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				HttpHeaders headers = request.getHeaders();
				headers.add(Constans.SERVERAUTH_HEADER, JSONObject.toJSONString(JwtUtil.getToken(appName)));
				return execution.execute(request, body);
			}
		});
		temp.setInterceptors(interceptors);
		return temp;
	}

	public static void main(String[] args) {
		SpringApplication.run(GcfGatewayWebApplication.class, args);
	}
}
