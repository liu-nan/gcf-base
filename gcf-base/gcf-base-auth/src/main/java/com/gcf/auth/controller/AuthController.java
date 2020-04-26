package com.gcf.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcf.common.bean.ResponseData;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@PostMapping("/token")
	public ResponseData auth(String param) {
		return ResponseData.ok(ResponseData.SUCCESS_MSG, "token");
	}
}
