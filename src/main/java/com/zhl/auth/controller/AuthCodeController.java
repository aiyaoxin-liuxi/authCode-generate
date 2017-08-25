package com.zhl.auth.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhl.auth.controller.common.BaseController;
import com.zhl.auth.pojo.AuthInfo;
import com.zhl.auth.pojo.enums.auth.AuthKeyType;
import com.zhl.auth.service.IAuthInfoService;
import com.zhl.auth.util.Stringer;

/**
 * 认证码接口类
 * @author 刘熙
 */
@Controller
@RequestMapping(value = "/authCode")
public class AuthCodeController extends BaseController{

	private Logger logs = LoggerFactory.getLogger(AuthCodeController.class);
	
	@Resource
	private IAuthInfoService authInfoService;
	
	/**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping(value = "/toAddAuthInfo")
    @ResponseBody
    public Object toAddAuthInfo(ModelMap model, AuthInfo authInfo){
        logs.info("###>>>>>>跳转添加页面.......");
        Map<String, Object> keyTypeMap = AuthKeyType.getAllList();
        model.addAttribute("keyTypeMap", keyTypeMap);
        return new ModelAndView("/sys/sysuser/addAuthInfo");
    }
	
	/**
     * 添加
     * @return
     */
    @RequestMapping(value = "/addAuthInfo")
    @ResponseBody
    public Object addAuthInfo(ModelMap model, AuthInfo authInfo){
        logs.info("###>>>>>>进入添加接口，准备添加.......");
        int resInt;
        try {
            resInt = authInfoService.addAuthInfo(authInfo);
            if(resInt == 1){
                logs.info("###>>>>>>添加成功");
                return success("添加成功", resInt);
            }
        } catch (Exception e) {
            logs.info("###>>>>>>添加失败：" + e.getMessage());
        }
        return error("添加失败");
    }
    
    /**
     * 跳转到修改页面
     * @return
     */
    @RequestMapping(value = "/toUpdateAuthInfo")
    @ResponseBody
    public Object toUpdateAuthInfo(ModelMap model, String id){
        logs.info("###>>>>>>跳转修改页面.......");
        if(Stringer.isNullOrEmpty(id)){
            return error("id不能为空");
        }
        AuthInfo authInfo = authInfoService.queryAuthInfoById(id);
        Map<String, Object> keyTypeMap = AuthKeyType.getAllList();
        model.addAttribute("authInfo", authInfo);
        model.addAttribute("keyTypeMap", keyTypeMap);
        return new ModelAndView("/sys/sysuser/updateAuthInfo");
    }
    
    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/updateAuthInfo")
    @ResponseBody
    public Object updateAuthInfo(ModelMap model, AuthInfo authInfo){
        logs.info("###>>>>>>进入修改接口，准备修改.......");
        int resInt;
        try {
            resInt = authInfoService.updateAuthInfo(authInfo);
            if(resInt == 1){
                logs.info("###>>>>>>修改成功");
                return success("修改成功", resInt);
            }
        } catch (Exception e) {
            logs.info("###>>>>>>修改失败：" + e.getMessage());
        }
        return error("修改失败");
    }
	
	 /**
     * 获取列表
     * @return
     */
    @RequestMapping(value = "/getAuthInfoList")
    @ResponseBody
    public Object getAuthInfoList(ModelMap model, AuthInfo authInfo, Integer pageNo, Integer pageSize){
        
        logs.info("###>>>>>>进入获取认证码列表接口，准备获取.......");
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageInfo<AuthInfo> pageInfo = null;
        
        pageInfo = authInfoService.getAuthInfoList(authInfo, pageNo, pageSize);
        
        model.addAttribute("authInfoList", pageInfo.getList());
        model.addAttribute("pageNo", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getPageSize());
        model.addAttribute("total", pageInfo.getTotal());
        model.addAttribute("navigatepageNums", pageInfo.getNavigatepageNums());
        model.addAttribute("pages", pageInfo.getPages());
        model.addAttribute("prePage", pageInfo.getPrePage());
        model.addAttribute("nextPage", pageInfo.getNextPage());
        logs.info("###>>>>>>获取认证码列表完成");
        return new ModelAndView("/sys/sysuser/authList");
    }
    
    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/delAuthInfo")
    @ResponseBody
    public Object delAuthInfo(ModelMap model, String id){
        logs.info("###>>>>>>进入删除接口，准备逻辑删除.......");
        int resInt;
        try {
            resInt = authInfoService.delAuthInfo(id);
            if(resInt == 1){
                logs.info("###>>>>>>删除成功");
                return success("删除成功", resInt);
            }
        } catch (Exception e) {
            logs.info("###>>>>>>删除失败：" + e.getMessage());
        }
        return error("删除失败");
    }
    
}
