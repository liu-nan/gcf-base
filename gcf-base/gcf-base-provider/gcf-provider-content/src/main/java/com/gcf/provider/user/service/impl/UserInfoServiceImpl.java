package com.gcf.provider.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcf.provider.user.mapper.SysUserMapper;
import com.gcf.provider.user.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public void createUserInfo(){
		
	}


	@Cacheable(value="Users", key="#userId")
	@Override
	public Map<String, Object> findById(String userId) {
		return sysUserMapper.findById(userId);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void insert(Map<String, Object> userInfo) {
		sysUserMapper.insert(userInfo);
		Map<String, Object> mp = new HashMap<>();
		mp.put("userName", "123");
		sysUserMapper.insert(userInfo);
	}

}
