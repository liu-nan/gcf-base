package com.gcf.provider.permission.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcf.common.bean.ResponseData;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	@PostMapping("/loadUserInfo")
	public ResponseData loadUserInfo(@RequestParam("userId") String userId) {
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("userId", userId);
		userInfo.put("userName", userId+"-usernameaaaaaa");
		return ResponseData.ok(userInfo);
	}
}
