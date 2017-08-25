package com.zhl.auth.interceptor;

import org.apache.log4j.Logger;

/**
 * 启动初始化类
 * @author 刘熙
 */
public class AuthInit {
    
	private Logger logger = Logger.getLogger(AuthInit.class);
	
	public void initMethod() throws Exception {  
		logger.info("启动执行---start");
        
        
        
        logger.info("启动执行---end");
    }  

}
