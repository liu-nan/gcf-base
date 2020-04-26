package com.gcf.gateway.mobile.service.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcf.common.bean.ResponseData;

@FeignClient("gcf-provider-user")
public interface UserService {

	@PostMapping("/save")
	public ResponseData save();
}
