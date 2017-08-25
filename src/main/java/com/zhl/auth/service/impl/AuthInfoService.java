package com.zhl.auth.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pub.util.date.DateConverter;
import org.pub.util.uuid.KeySn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhl.auth.dao.IAuthInfoDao;
import com.zhl.auth.pojo.AuthInfo;
import com.zhl.auth.pojo.enums.auth.AuthKeyType;
import com.zhl.auth.pojo.enums.auth.AuthState;
import com.zhl.auth.pojo.enums.auth.AuthType;
import com.zhl.auth.pojo.enums.common.IsDel;
import com.zhl.auth.service.IAuthInfoService;
import com.zhl.auth.util.DateTools;
import com.zhl.auth.util.EncodeUtils;
import com.zhl.auth.util.RSAUtil;
import com.zhl.auth.util.Stringer;

@Service("authCodeService")
public class AuthInfoService implements IAuthInfoService {
    
    private Logger logs = LoggerFactory.getLogger(AuthInfoService.class);
    
    @Resource
    private IAuthInfoDao authInfoDao;
    
    @Override
    public int addAuthInfo(AuthInfo authInfo) throws Exception {
        
        // 根据传入选择加密算法
        if(null == createAuthCode(authInfo)){
            return 0;
        }
        // 创建必填补充参数
        createAuthInfo(authInfo);
        return authInfoDao.addAuthInfo(authInfo);
    }
    
    @Override
    public int updateAuthInfo(AuthInfo authInfo) throws Exception {
        // 根据传入选择加密算法
        if(null == createAuthCode(authInfo)){
            return 0;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("sysName", authInfo.getSysName());
        paramMap.put("useCompanyName", authInfo.getUseCompanyName());
        paramMap.put("keyType", authInfo.getKeyType());
        paramMap.put("sysAuth", authInfo.getSysAuth());
        paramMap.put("publicKey", authInfo.getPublicKey());
        paramMap.put("privateKey", authInfo.getPrivateKey());
        paramMap.put("startDate", authInfo.getStartDate());
        paramMap.put("endDate", authInfo.getEndDate());
        paramMap.put("remark", authInfo.getRemark());
        paramMap.put("updateDate", new Date());
        paramMap.put("id", authInfo.getId());
        return authInfoDao.updateAuthInfo(paramMap);
    }

    @Override
    public PageInfo<AuthInfo> getAuthInfoList(AuthInfo authInfo, Integer pageNo,Integer pageSize) {
        
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ID", authInfo.getId());
        paramMap.put("SYS_ID", authInfo.getSysId());
        paramMap.put("USE_COMPANY_NAME", authInfo.getUseCompanyName());
        paramMap.put("SYS_NAME", authInfo.getSysName());
        paramMap.put("START_DATE", authInfo.getStartDate());
        paramMap.put("END_DATE", authInfo.getEndDate());
        
        PageHelper.startPage(pageNo, pageSize);
        List<AuthInfo> list = authInfoDao.getAuthInfoList(paramMap);
        PageInfo<AuthInfo> page = new PageInfo<AuthInfo>(list);
        
        return page;
    }
    
    @Override
    public AuthInfo queryAuthInfoById(String id) {
        return authInfoDao.queryAuthInfoById(id);
    }
    
    
    @Override
    public AuthInfo createAuthCode(AuthInfo authInfo) throws Exception {
        logs.info("###>>>>>>添加前生成认证码.......");
        if(null == authInfo && null == authInfo.getKeyType()){
            return null;
        }
        cleanKey(authInfo);
        
        Map<String, Object> resMap = new HashMap<String, Object>();
        StringBuilder sb = new StringBuilder();
        String dateStr = DateConverter.date2String(authInfo.getEndDate(), "yyyyMMdd");
        String keyStr = sb.append(dateStr).append(authInfo.getUseCompanyName()).toString();
        logs.info("###>>>>>>生成前认证码参数:" + keyStr);
        
        if(AuthKeyType.CODE01.getCode().equals(authInfo.getKeyType())){// BASEE64
            logs.info("###>>>>>>生成认证--BASE64");
            byte[] keyByte = keyStr.getBytes();
            String b64Key = EncodeUtils.base64Encode(keyByte);// utf-8
            authInfo.setSysAuth(b64Key);
            
        } else if(AuthKeyType.CODE02.getCode().equals(authInfo.getKeyType())){// RAS加密
            logs.info("###>>>>>>生成认证--RSA");
            RSAUtil rUtil = new RSAUtil();
            Map<String, Object> map = rUtil.createRSA(512);
            String publicKey = (String) map.get("publicKey");
            String privateKey = (String) map.get("privateKey");
            String getEptStr = rUtil.encrypt(keyStr, "UTF-8", publicKey);
            
            authInfo.setPublicKey(publicKey);
            authInfo.setPrivateKey(privateKey);
            authInfo.setSysAuth(getEptStr);
        }
        logs.info("###>>>>>>生成认证码完成......认证码：" + authInfo.getSysAuth());
        return authInfo;
    }
    
    /**
     * 生成前清除已有的key
     */
    private void cleanKey(AuthInfo authInfo){
        authInfo.setSysAuth(null);
        authInfo.setPublicKey(null);
        authInfo.setPrivateKey(null);
    }
    
    /**
     * 创建authInfo的公用必填（暂未提供接口）
     * 生成必填项为：
     * id、状态、类型、创建时间、是否删除参数
     * @param authInfo
     */
    private void createAuthInfo(AuthInfo authInfo){
        authInfo.setId(KeySn.getKey());
        authInfo.setAuthState(AuthState.CODE00.getCode());
        authInfo.setAuthType(AuthType.CODE00.getCode());
        authInfo.setCreateDate(new Date());
        authInfo.setIsdel(IsDel.CODE00.getCode());
    }

    @Override
    public int delAuthInfo(String id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isdel", IsDel.CODE01.getCode());
        paramMap.put("id", id);
        return authInfoDao.delAuthInfo(paramMap);
    }

    
    

}
