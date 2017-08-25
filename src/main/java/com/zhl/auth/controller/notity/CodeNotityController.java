package com.zhl.auth.controller.notity;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhl.auth.controller.common.BaseController;
import com.zhl.auth.interceptor.anno.NoAuth;
import com.zhl.auth.pojo.AuthInfo;
import com.zhl.auth.pojo.enums.auth.AuthKeyType;
import com.zhl.auth.service.IAuthInfoService;

/**
 * 认证码返回通知检查接口
 * @author 刘熙
 */
@Controller
@RequestMapping(value = "/codeNotity")
public class CodeNotityController extends BaseController {
    
    private Logger logs = LoggerFactory.getLogger(CodeNotityController.class);
    
    @Resource
    private IAuthInfoService authInfoService;
    
    
    /**
     * 检查认证码
     * @return
     */
    @NoAuth
    @RequestMapping(value = "/check")
    @ResponseBody
    public Object check(ModelMap model, String id, String key){
        logs.info("###>>>>>>【通知】用于验证key.......,参数：id=" + id + ",key=" + key);
        Map<String, Object> reMap = new HashMap<String, Object>();
        String reStr = "111111";
        
        AuthInfo authInfo = authInfoService.queryAuthInfoById(id);
        if(null != authInfo){
            if(key.equals(authInfo.getSysAuth())){
                reStr = "000000";
            }
        }
        reMap.put("code", reStr);
        return reMap;
    }

}
