package com.gcf.gateway.web.fallback.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gcf.common.bean.ResponseData;
import com.gcf.gateway.web.api.UserInfoService;

@Component
public class UserInfofallback implements UserInfoService {

	@Override
	public ResponseData loadUserInfo(String userId) {
		Map<String, Object> data = new HashMap<>();
		data.put("userName", "Hystrix-username");
		data.put("password", "Hystrix-password");
		return ResponseData.error(data);
	}
}
