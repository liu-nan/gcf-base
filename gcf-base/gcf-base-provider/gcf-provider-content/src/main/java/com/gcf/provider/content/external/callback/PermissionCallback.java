package com.gcf.provider.content.external.callback;

import com.gcf.common.bean.ResponseData;
import com.gcf.provider.content.external.PermissionService;

public class PermissionCallback implements PermissionService {

	@Override
	public ResponseData loadUserInfo(String userId) {
		return ResponseData.error("服务调用失败");
	}

}
