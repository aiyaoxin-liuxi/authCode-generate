package com.zhl.auth.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.zhl.auth.pojo.AuthInfo;



public interface IAuthInfoService {
    
    /**
     * 添加
     * @param authInfo
     * @return
     */
    int addAuthInfo(AuthInfo authInfo) throws Exception;
    /**
     * 修改，重新生成
     * @param authInfo
     * @return
     */
    int updateAuthInfo(AuthInfo authInfo) throws Exception;
    /**
     * 根据id查询
     * @param authInfo
     * @return
     */
    AuthInfo queryAuthInfoById(String id);
    /**
     * 获取authInfo分页列表
     * @param authInfo 
     * @return
     */
    PageInfo<AuthInfo> getAuthInfoList(AuthInfo authInfo, Integer pageNo, Integer pageSize);
    /**
     * 生成认证码
     * @param sysName 系统名称
     * @param endDate 到期日期
     * @return
     */
    AuthInfo createAuthCode(AuthInfo authInfo) throws Exception;
    /**
     * 删除
     * @param id
     * @return
     */
    int delAuthInfo(String id);
}
