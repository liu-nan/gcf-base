package com.gcf.gateway.mobile.service.permission;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcf.common.bean.ResponseData;

@FeignClient("gcf-provider-permission")
public interface PermissionService {

	@PostMapping("/findPermission")
	public ResponseData findPermission(String userId);
}
