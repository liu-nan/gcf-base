package com.gcf.gateway.mobile.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcf.common.bean.ResponseData;
import com.gcf.gateway.mobile.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseData save(String username, String password) {
		return userService.save();
	}
}
