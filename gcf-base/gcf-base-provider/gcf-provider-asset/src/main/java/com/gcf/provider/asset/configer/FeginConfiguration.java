package com.gcf.provider.asset.configer;


import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;
import com.gcf.common.constans.Constans;
import com.gcf.common.util.JwtUtil;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeginConfiguration implements RequestInterceptor {

	@Value("${spring.application.name}")
	private String appName;
	@Override
	public void apply(RequestTemplate template) {
		template.header(Constans.SERVERAUTH_HEADER, JSONObject.toJSONString(JwtUtil.getToken(appName)));
	}

}
