package com.zhl.auth.pojo.enums.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证码信息表--加密类型
 * @author 刘熙
 *
 */
public enum AuthType {
    /**
     * 默认
     */
    CODE00("00","默认");
    
    private String code;
    private String name;
    
    private AuthType(String code,String name){
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
        for (AuthType t : AuthType.values()) {
            if (t.getCode().equals(code)) {
                return t.name;
            }
        }
        return null;
    }
    
    public static String getCode(String text) {
        for (AuthType t : AuthType.values()) {
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
        for (AuthType s : AuthType.values()){
            map.put(s.getCode(), s.getName());
        }
        return map;
    }
}
