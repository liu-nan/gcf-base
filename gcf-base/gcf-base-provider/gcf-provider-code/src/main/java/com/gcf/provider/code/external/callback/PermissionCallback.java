package com.gcf.provider.code.external.callback;

import com.gcf.common.bean.ResponseData;
import com.gcf.provider.code.external.PermissionService;

public class PermissionCallback implements PermissionService {

	@Override
	public ResponseData loadUserInfo(String userId) {
		return ResponseData.error("服务调用失败");
	}

}
