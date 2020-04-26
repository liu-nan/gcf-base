package com.gcf.gateway.web.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcf.common.bean.ResponseData;
import com.gcf.gateway.web.configer.FeginConfiguration;
import com.gcf.gateway.web.fallback.api.UserInfofallback;

@FeignClient(name="GCF-PROVIDER-USER", fallback=UserInfofallback.class, configuration=FeginConfiguration.class)
public interface UserInfoService {

	@PostMapping(value="/userInfo/loadUserInfo", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseData loadUserInfo(String userId);
}
