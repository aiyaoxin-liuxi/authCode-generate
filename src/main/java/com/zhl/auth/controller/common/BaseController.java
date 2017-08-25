package com.zhl.auth.controller.common;

import java.math.BigDecimal;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zhl.auth.pojo.common.ResponseEntity;
import com.zhl.auth.util.Constant;
import com.zhl.auth.util.Stringer;

public class BaseController {
    
    
    private Logger logs = LoggerFactory.getLogger(BaseController.class);
    
    protected Object error(String errorCode, String errorMessage){
        return new ResponseEntity(errorCode, errorMessage).toJson();
    }

    protected Object error(String errorMessage){
        return new ResponseEntity(null, errorMessage).toJson();
    }
    protected Object success(Object data){
        return new ResponseEntity(data).toJson();
    }
    protected Object success(String errorMessage, Object data){
        return new ResponseEntity(errorMessage, data).toJson();
    }
    
//    protected Object page(int pageNo, int pageSize){
//        pageNo = pageNo == null ? 1 : pageNo;
//        pageSize = pageSize == null ? 10 : pageSize;
//    }
    
    protected boolean isNullOrEmpty(Object obj) {
        return Stringer.isNullOrEmpty(obj);
    }

    /**
     * @author by  Apr 13, 2015
     *
     * @desc 获取webapp完整URL. e.g http://www.abc.com/app/a/b/c?a=b&c=d...
     * @param request
     * @return
     */
    protected final String getRequestURL(HttpServletRequest request) {

        if (request == null) {
            return "";
        }
        String url = "";
        url = "http://" + request.getServerName() // 服务器地址
        // + ":"
        // + request.getServerPort() //端口号
                + request.getContextPath() // 项目名称
                + request.getServletPath(); // 请求页面或其他地址
        try {
            // 参数
            Enumeration<?> names = request.getParameterNames();

            int i = 0;
            String queryString = request.getQueryString();
            if (null != queryString && !"".equals(queryString) && (!queryString.equals("null"))) {
                url = url + "?" + request.getQueryString();
                i++;
            }
            if (names != null) {
                while (names.hasMoreElements()) {
                    if (i == 0) {
                        url = url + "?";
                    }
                    String name = (String) names.nextElement();
                    if (url.indexOf(name) < 0) {
                        url = url + "&";
                        String value = request.getParameter(name);
                        if (value == null) {
                            value = "";
                        }
                        url = url + name + "=" + value;
                        i++;
                    }
                    // java.net.URLEncoder.encode(url, "ISO-8859");
                }
            }
            // String enUrl = java.net.URLEncoder.encode(url, "utf-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return url;
    }
    

//    public void checkLoginStatus(HttpServletRequest request) throws NoLoginException {
//        Object attribute = request.getSession().getAttribute(Constant.LOGIN_USER_MOBILE);
//        if(Stringer.isNullOrEmpty(attribute)){
//            logs.debug("###>>>>没有登陆");
//            throw new NoLoginException();
//        }
//        
//    }
//    public void checkLoginStatus4Sys(HttpServletRequest request) throws NoLogin4SysException {
//        Object attribute = request.getSession().getAttribute(Constant.LOGIN_USER_ID4SYS);
//        if(Stringer.isNullOrEmpty(attribute)){
//            logs.debug("###>>>>没有登陆(后台)");
//            throw new NoLogin4SysException();
//        }
//        
//    }

    //后台系统的userId
    public String getLoginUserId4Sys(HttpServletRequest request) {
        return getAttr(request,Constant.LOGIN_USER_ID4SYS);
    }

    public String getLoginUserType(HttpServletRequest request) {
        return getAttr(request,Constant.LOGIN_USER_TYPE);
    }
    
    public String getLoginUserMobile(HttpServletRequest request) {
        return getAttr(request,Constant.LOGIN_USER_MOBILE);
    }
    
    private String getAttr(HttpServletRequest request,String key) {
        Object attribute = request.getSession().getAttribute(key);
        if(Stringer.isNullOrEmpty(attribute)){
            logs.debug("###>>>>没有登陆");
            throw new RuntimeException("没有登陆");
        }
        return attribute.toString();
    }
    
    public void alertError(ModelMap model, String errMsg){
        alertError(model, "errMsg", errMsg);
    }
    
    public void alertError(ModelMap model, String errCode, String errMsg){
        model.addAttribute(errCode, "<script type=\"text/javascript\">alert('"+errMsg+"')</script>");
    }
    
    public void alertError(RedirectAttributes attr, String errMsg){
        alertError(attr, "errMsg", errMsg);
    }
    public void alertError(RedirectAttributes attr, String errCode, String errMsg){
        attr.addFlashAttribute(errCode, "<script type=\"text/javascript\">alert('"+errMsg+"')</script>");
    }
    


}
