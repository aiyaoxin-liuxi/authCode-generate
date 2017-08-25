package com.zhl.auth.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserInfo implements Serializable  {
    
    /**
     * 主键id
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 用户状态
     */
    private String userState;
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
     * 是否删除
     */
    private String isdel;
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
     * 获取userName userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * 设置userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * 获取passWord passWord
     */
    public String getPassWord() {
        return passWord;
    }
    /**
     * 设置passWord passWord
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    /**
     * 获取userType userType
     */
    public String getUserType() {
        return userType;
    }
    /**
     * 设置userType userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }
    /**
     * 获取userState userState
     */
    public String getUserState() {
        return userState;
    }
    /**
     * 设置userState userState
     */
    public void setUserState(String userState) {
        this.userState = userState;
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

}
