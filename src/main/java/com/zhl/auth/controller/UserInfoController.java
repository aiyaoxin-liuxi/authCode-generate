package com.zhl.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhl.auth.controller.common.BaseController;
import com.zhl.auth.interceptor.anno.NoAuth;
import com.zhl.auth.pojo.UserInfo;
import com.zhl.auth.service.IUserInfoService;
import com.zhl.auth.util.Constant;
import com.zhl.auth.util.Stringer;

/**
 * 	后台用户登陆
 */
@Controller
@RequestMapping(value = "/user")
public class UserInfoController extends BaseController{

	private Logger logs = LoggerFactory.getLogger(UserInfoController.class);
	
	@Autowired
	IUserInfoService userINfoService;

	
	@RequestMapping(value = "/login")
	@NoAuth
	public Object loginGet(Model model, HttpServletRequest request) {
		logs.debug("##>>>login get Request OK!");
		return new ModelAndView("/sys/sysuser/login");
//		return "forward:/sys/sysuser/login";
	}
	/**
	 * 
	  * loginPost登陆
	  * @Title: loginPost
	  * @Description: TODO
	  * @param @param model
	  * @param @param request
	  * @param @param sysUser
	  * @param @return    设定文件
	  * @return Object    返回类型
	  * @throws
	 */
	@RequestMapping(value = "/login",method={RequestMethod.POST})@NoAuth
	public @ResponseBody Object loginPost(Model model, HttpServletRequest request,UserInfo userInfo) {
		logs.debug("##>>>login  loginPost OK!");
		String username = userInfo.getUserName();
		String pwd = userInfo.getPassWord();
		if(Stringer.isNullOrEmpty(username) || Stringer.isNullOrEmpty(pwd)){
			return error("请正确填写 用户名 密码");
		}
		UserInfo reUserInfo = userINfoService.login(userInfo);
		if(null == reUserInfo){
		    return error("用户名密码错");
		}
        request.getSession().setAttribute(Constant.LOGIN_USER_ID4SYS, reUserInfo.getId());
        request.getSession().setAttribute(Constant.USER_NAME, reUserInfo.getUserName());
        request.getSession().setAttribute(Constant.LOGIN_USER_TYPE, "03");//
        logs.debug("登陆成功，放入 USER_NAME： "+ reUserInfo.getUserName() +"\t  USER_ID:"+reUserInfo.getId());
        return success("登陆成功", reUserInfo);
	}
	
    @RequestMapping(value = "/index")
    public Object index(Model model, HttpServletRequest request,Integer pageNo,Integer pageSize) {
        logs.debug("##>>> get index OK!");
        return new ModelAndView("/sys/sysuser/index");
    }
	
//	
//	/**
//	 * @throws NoLogin4SysException 
//	 * 
//	  * index首页
//	  * @Title: index
//	  * @Description: TODO
//	  * @param @param model
//	  * @param @param request    设定文件
//	  * @return void    返回类型
//	  * @throws
//	 */
//	@RequestMapping(value = "/settList")
//	public void settList(Model model, HttpServletRequest request,Integer pageNo,Integer pageSize) throws NoLogin4SysException {
//		super.checkLoginStatus4Sys(request);
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		pageNo=pageNo==null?1:pageNo;
//		pageSize=pageSize==null?Constant.pageSize:pageSize;
//		PageInfo<SettlementInfo> pageInfo=settlementService.queryListByCompayId(paramMap,  pageNo, pageSize);
//		setworknameAndOtherAttr(pageInfo);
//		Stringer.setPageInfo(model,pageInfo);
//		
//		model.addAttribute(Constant.DIV_ACTIVE, DivActive.SETT_LIST.getCode());
//		logs.debug("##>>> get settList OK!");
//	}
//	
//	private void setworknameAndOtherAttr(PageInfo<SettlementInfo> pageInfo) {
//		if(Stringer.isNullOrEmpty(pageInfo)){
//			return ;
//		}
//		List<SettlementInfo> list = pageInfo.getList();
//		if(Stringer.isNullOrEmpty(list)){
//			return ;
//		}
//		List<SettlementInfo> newlist=new ArrayList<SettlementInfo>();
//		for(SettlementInfo each:list){
//			String workId = each.getWorkId();
//			WorkInfo workInfo = workInfoService.queryById(workId);
//			each.setWorkInfo(workInfo);
//			String state = each.getState();
//			if(!Stringer.isNullOrEmpty(state)){
//				String text = SettlementInfoState.getText(state);
//				if(!Stringer.isNullOrEmpty(text)){
//					each.setState(text);
//				}
//			}
//			newlist.add(each);
//		}
//		pageInfo.setList(newlist);
//	}
	
}
