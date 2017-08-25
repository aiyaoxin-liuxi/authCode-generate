package com.zhl.auth.pojo.enums.auth;

/**
 * 验证码信息表--验证状态
 * @author 刘熙
 *
 */
public enum AuthState {
    /**
     * 默认
     */
    CODE00("00","默认");
    
    private String code;
    private String name;
    
    private AuthState(String code,String name){
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
        for (AuthState t : AuthState.values()) {
            if (t.getCode().equals(code)) {
                return t.name;
            }
        }
        return null;
    }
    
    public static String getCode(String text) {
        for (AuthState t : AuthState.values()) {
            if (t.getName().equals(text)) {
                return t.code;
            }
        }
        return null;
    }

    public String getText() {
        return name;
    }
}
