package com.zhl.auth.util;



/**
 * 常量
 */
public class Constant {

	public static Integer pageSize=10;
	//页面左侧激活div标志 配合枚举类DivActive
	public static final String DIV_ACTIVE = "active";
	public static final String LOGIN_USER_TYPE="userType";
	public static final String IMAGE_RESET_PATH = "/static/img/";
	public static final String LOGIN_USER_MOBILE="LOGIN_USER_MOBILE";
	
	public static final String USER_NAME="USER_NAME";
	//后台
	public static final String LOGIN_USER_ID4SYS="LOGIN_USER_ID4SYS";
	
	public static  String REPOSITORY_IMG = "";
	static{
		REPOSITORY_IMG = Constant.class.getClassLoader().getResource("/").getFile().replace("/WEB-INF/classes/", IMAGE_RESET_PATH);
	}
	//项目路径
	public static final String PROJECT_CONTEXT=Stringer.nullToEmpty(PropsHandler.getProperty("project.context"));//异步通知地址
	//
	public static final String IMAGE_SERVER_URL=Stringer.nullToEmpty(PropsHandler.getProperty4Util("image_server_url"));
	public static final String IMAGE_SERVER_URL_LOAD=Stringer.nullToEmpty(PropsHandler.getProperty4Util("image_server_url_load"));
	
	
}
