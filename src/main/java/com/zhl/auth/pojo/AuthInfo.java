package com.zhl.auth.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zhl.auth.pojo.enums.auth.AuthKeyType;

public class AuthInfo implements Serializable  {
    
    /**
     * 验证信息表id
     */
    private String id;
    /**
     * 系统id
     */
    private String sysId;
    /**
     * 系统使用公司名称
     */
    private String useCompanyName;
    /**
     * 系统名称
     */
    private String sysName;
    /**
     * 系统验证码
     */
    private String sysAuth;
    /**
     * 系统公钥
     */
    private String publicKey;
    /**
     * 系统私钥
     */
    private String privateKey;
    /**
     * 加密类型
     */
    private String keyType;
    /**
     * 起始使用时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date startDate;
    /**
     * 到期时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date endDate;
    /**
     * 备注
     */
    private String remark;
    /**
     * 验证类型
     */
    private String authType;
    /**
     * 验证状态
     */
    private String authState;
    /**
     * 预留字段1
     */
    private String rev1;
    /**
     * 预留字段2
     */
    private String rev2;
    /**
     * 预留字段3
     */
    private String rev3;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date createDate;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date updateDate;
    /**
     * 修改人
     */
    private String updateUser;
    /**
     * 逻辑删除标识
     */
    private String isdel;

    // ======================================== 以下为页面显示 ========================================
    
    /**
     * 加密类型---用于页面显示
     */
    private String keyTypeName;
    
    // ======================================= get and set =======================================
    /**
     * 获取id id
     */
    public String getId() {
        return id;
    }
    /**
     * 设置id id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * 获取sysId sysId
     */
    public String getSysId() {
        return sysId;
    }
    /**
     * 设置sysId sysId
     */
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }
    /**
     * 获取useCompanyName useCompanyName
     */
    public String getUseCompanyName() {
        return useCompanyName;
    }
    /**
     * 设置useCompanyName useCompanyName
     */
    public void setUseCompanyName(String useCompanyName) {
        this.useCompanyName = useCompanyName;
    }
    /**
     * 获取sysName sysName
     */
    public String getSysName() {
        return sysName;
    }
    /**
     * 设置sysName sysName
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }
    /**
     * 获取sysAuth sysAuth
     */
    public String getSysAuth() {
        return sysAuth;
    }
    /**
     * 设置sysAuth sysAuth
     */
    public void setSysAuth(String sysAuth) {
        this.sysAuth = sysAuth;
    }
    /**
     * 获取publicKey publicKey
     */
    public String getPublicKey() {
        return publicKey;
    }
    /**
     * 设置publicKey publicKey
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    /**
     * 获取privateKey privateKey
     */
    public String getPrivateKey() {
        return privateKey;
    }
    /**
     * 设置privateKey privateKey
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
    /**
     * 获取keyType keyType
     */
    public String getKeyType() {
        return keyType;
    }
    /**
     * 设置keyType keyType
     */
    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }
    /**
     * 获取startDate startDate
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * 设置startDate startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * 获取endDate endDate
     */
    public Date getEndDate() {
        return endDate;
    }
    /**
     * 设置endDate endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    /**
     * 获取remark remark
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 设置remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * 获取authType authType
     */
    public String getAuthType() {
        return authType;
    }
    /**
     * 设置authType authType
     */
    public void setAuthType(String authType) {
        this.authType = authType;
    }
    /**
     * 获取authState authState
     */
    public String getAuthState() {
        return authState;
    }
    /**
     * 设置authState authState
     */
    public void setAuthState(String authState) {
        this.authState = authState;
    }
    /**
     * 获取rev1 rev1
     */
    public String getRev1() {
        return rev1;
    }
    /**
     * 设置rev1 rev1
     */
    public void setRev1(String rev1) {
        this.rev1 = rev1;
    }
    /**
     * 获取rev2 rev2
     */
    public String getRev2() {
        return rev2;
    }
    /**
     * 设置rev2 rev2
     */
    public void setRev2(String rev2) {
        this.rev2 = rev2;
    }
    /**
     * 获取rev3 rev3
     */
    public String getRev3() {
        return rev3;
    }
    /**
     * 设置rev3 rev3
     */
    public void setRev3(String rev3) {
        this.rev3 = rev3;
    }
    /**
     * 获取createDate createDate
     */
    public Date getCreateDate() {
        return createDate;
    }
    /**
     * 设置createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**
     * 获取createUser createUser
     */
    public String getCreateUser() {
        return createUser;
    }
    /**
     * 设置createUser createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    /**
     * 获取updateDate updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }
    /**
     * 设置updateDate updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    /**
     * 获取updateUser updateUser
     */
    public String getUpdateUser() {
        return updateUser;
    }
    /**
     * 设置updateUser updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    /**
     * 获取isdel isdel
     */
    public String getIsdel() {
        return isdel;
    }
    /**
     * 设置isdel isdel
     */
    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }
    /**
     * 获取keyTypeName keyTypeName  --页面显示
     */
    public String getKeyTypeName() {
        if(null != keyType && !"".equals(keyType.trim())){
            return AuthKeyType.getText(keyType);
        }
        return null;
    }
    

}
