package com.zhl.auth.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhl.auth.pojo.UserInfo;

public interface IUserInfoService {

	UserInfo getUserById(String id);

	List<UserInfo> getUserByUsername(String username);
	
	UserInfo login(UserInfo userInfo);

}
