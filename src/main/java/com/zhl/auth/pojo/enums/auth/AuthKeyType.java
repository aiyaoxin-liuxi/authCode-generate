package com.zhl.auth.pojo.enums.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证码信息表--验证类型
 * @author 刘熙
 *
 */
public enum AuthKeyType {
    
    /**
     * 无加密
     */
    CODE00("00","无加密"),
    /**
     * BASE64加密
     */
    CODE01("01","BASE64加密"),
    /**
     * RAS加密
     */
    CODE02("02","RAS加密");
    
    private String code;
    private String name;
    
    private AuthKeyType(String code,String name){
        this.code=code;
        this.name=name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
   public static String getText(String code) {
        for (AuthKeyType t : AuthKeyType.values()) {
            if (t.getCode().equals(code)) {
                return t.name;
            }
        }
        return null;
    }
    
    public static String getCode(String text) {
        for (AuthKeyType t : AuthKeyType.values()) {
            if (t.getName().equals(text)) {
                return t.code;
            }
        }
        return null;
    }

    public String getText() {
        return name;
    }
    
    public static Map<String, Object> getAllList() {
        Map<String, Object> map = new HashMap<String, Object>();
        for (AuthKeyType s : AuthKeyType.values()){
            map.put(s.getCode(), s.getName());
        }
        return map;
    }
}
