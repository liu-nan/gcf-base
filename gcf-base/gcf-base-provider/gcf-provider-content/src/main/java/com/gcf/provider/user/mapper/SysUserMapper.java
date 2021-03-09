package com.gcf.provider.user.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper {

	@Select("SELECT * FROM sys_user WHERE user_id = #{userId}")
	public Map<String, Object> findById(String userId);
	
	@Insert("INSERT INTO sys_user(user_id, user_name) values(#{userId}, #{userName})")
	public void insert(Map<String, Object> map);
}
