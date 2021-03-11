package com.gcf.provider.tag.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcf.common.bean.ResponseData;
import com.gcf.provider.tag.external.PermissionService;
import com.gcf.provider.tag.service.UserInfoService;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
	
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private UserInfoService userInfoService;

	@PostMapping("/loadUserInfo")
	public ResponseData loadUserInfo(String userId) {
//		Map<String, Object> userInfo = new HashMap<>();
//		userInfo.put("userId", userId);
//		userInfo.put("userName", userId+"-username");
//		return ResponseData.ok(userInfo);
		System.out.println("userId"+userId);
		return permissionService.loadUserInfo(userId);
	}
	@PostMapping("/findById")
	public ResponseData findById(String userId) {
		System.out.println("userId"+userId);
		return ResponseData.ok(userInfoService.findById(userId));
	}
	@PostMapping("/insert")
	public ResponseData insert(String userId, String userName) {
		System.out.println("userId"+userId);
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("userName", "userName");
		userInfoService.insert(map);
		return ResponseData.ok();
	}
}
