package com.gcf.provider.user.service.impl;

import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcf.provider.user.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public void createUserInfo(){
		
	}


	@Cacheable(value="Users", key="#userId")
	@Override
	public Map<String, Object> findById(String userId) {
		return null;
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void insert(Map<String, Object> userInfo) {
	}

}
