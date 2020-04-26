package com.gcf.provider.user.service;

import java.util.Map;

import com.gcf.common.exception.GcfException;

public interface UserInfoService {

	/**
	 * 创建用户信息
	 * @throws GcfException
	 */
	public void createUserInfo() throws GcfException;
	
	public Map<String, Object> findById(String userId);
	
	public void insert(Map<String, Object> userInfo);
}
