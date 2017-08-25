package com.zhl.auth.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhl.auth.pojo.AuthInfo;

public interface IAuthInfoDao {

    /**
     * 添加
     * @param authInfo
     * @return
     */
    public int addAuthInfo(AuthInfo authInfo);
    
    /**
     * 修改
     * @param authInfo
     * @return
     */
    public int updateAuthInfo(Map<String, Object> paramMap);
    
    /**
     * 根据主键查询
     * @param authInfo
     * @return
     */
    public AuthInfo queryAuthInfoById(@Param("id") String id);
    
    /**
     * 查询AuthInfo列表
     * @param map
     * @return
     */
	public List<AuthInfo> getAuthInfoList(Map<String, Object> map);
	
	/**
     * 逻辑删除
     * @param authInfo
     * @return
     */
    public int delAuthInfo(Map<String, Object> paramMap);
	
}
