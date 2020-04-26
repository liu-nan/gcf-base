package com.gcf.gateway.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.gcf.common.bean.ResponseData;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@Service
public class UserInfo {

	@Value("${spring.application.name}")
	private String appName;
	@Autowired
	private RestTemplate restTemplate;

	@Hystrix
	public ResponseData loadUserInfo(String userId) {
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("userId", userId);
		ResponseData response = restTemplate.postForObject("http://gcf-provider-user/userInfo/loadUserInfo", map, ResponseData.class);
		return response;
//		HttpHeaders header = new HttpHeaders();
//		header.add(Constans.SERVERAUTH_HEADER, JSONObject.toJSONString(JwtUtil.getToken(appName)));
//		//header(Constans.SERVERAUTH_HEADER, JSONObject.toJSONString(JwtUtil.getToken(appName)));
//		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
//		paramMap.add("userId", "20190225");
//		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(paramMap,header);
//		ResponseEntity<ResponseData> response = restTemplate.postForEntity("http://gcf-provider-user/userInfo/loadUserInfo", entity, ResponseData.class);//getForObject("http://gcf-provider-user/userInfo/loadUserInfo", ResponseData.class, userId);
//		return response.getBody();
	}
}
