package com.zhl.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.auth.dao.IUserInfoDao;
import com.zhl.auth.pojo.UserInfo;
import com.zhl.auth.service.IUserInfoService;
import com.zhl.auth.util.JsonUtil;
import com.zhl.auth.util.Stringer;

@Service("userInfoService")
public class UserInfoService implements IUserInfoService{
	

	private Logger logs = LoggerFactory.getLogger(UserInfoService.class);

	@Autowired
	IUserInfoDao userInfoDao;
	
	public UserInfo getUserById(String sid){
		return userInfoDao.getUserById(sid);
	}
	
	@Override
	public UserInfo login(UserInfo userInfo) {
	    
	    UserInfo userInfoDB = null;
		List<UserInfo> list = getUserByUsername(userInfo.getUserName());
		if(!Stringer.isNullOrEmpty(list) && list.size() == 1){
		    if(list.size() == 1){
	            userInfoDB = list.get(0);
	            String logPwd = Stringer.encryptLogPwd(userInfo.getPassWord());
	            logs.debug("登陆比对密码：encryptLogPwd ："+logPwd +" sysUserDb.getPwd():"+userInfoDB.getPassWord());
	            if(!logPwd.equals(userInfoDB.getPassWord())){
	                userInfoDB = null;
	            }
	        }
		} else if(list.size() > 1){
		    throw new RuntimeException("不应该有多个"+JsonUtil.toJson(userInfo));
		}
 		return userInfoDB;
	}

	public List<UserInfo> getUserByUsername(String userName) {
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("userName", userName);
		return userInfoDao.getUserByUsername(map);
	}

}
