package com.gcf.provider.user.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcf.common.bean.ResponseData;
import com.gcf.provider.user.configer.FeginConfiguration;
import com.gcf.provider.user.external.callback.PermissionCallback;

@FeignClient(name="GCF-PROVIDER-PERMISSION", fallback=PermissionCallback.class, configuration=FeginConfiguration.class)
public interface PermissionService {

	@PostMapping(value="/userInfo/loadUserInfo", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseData loadUserInfo(@RequestParam("userId") String userId);
}
