package com.zhl.auth.dao;

import java.util.List;
import java.util.Map;

import com.zhl.auth.pojo.UserInfo;

public interface IUserInfoDao {

	public UserInfo getUserById(String sid);
	
	public List<UserInfo> getUserByUsername(Map<String, Object> map);
}
