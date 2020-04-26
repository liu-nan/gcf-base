package com.gcf.gateway.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcf.common.bean.ResponseData;
import com.gcf.gateway.web.api.UserInfo;
import com.gcf.gateway.web.api.UserInfoService;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
	@Autowired
	private UserInfo userInfo;
	
	@Autowired
	private UserInfoService userInfoService;
	
	
	@PostMapping("/loadUserInfo")
	public ResponseData loadUserInfo(@RequestParam("userId") String userId) {
		return userInfo.loadUserInfo(userId);
	}
	@PostMapping("/loadUserInfo1")
	public ResponseData loadUserInfo1(@RequestParam("userId") String userId) {
		return userInfoService.loadUserInfo(userId);
	}
}
