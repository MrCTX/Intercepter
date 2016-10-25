package com.panda.intercepter;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
* @author MrC
* @date 2016年10月24日下午9:27:25
* @parameter
* @version
*/
@SuppressWarnings("serial")
public class MyInterceter extends AbstractInterceptor {

	public String intercept(ActionInvocation arg0) throws Exception {
		//获得ActionContext实例
		ActionContext context = arg0.getInvocationContext();
		//获得实例中的session
		Map<String, Object> session =  context.getSession();
		String name = (String) session.get("user");
		if (name != null && "admin".equals(name)) {
			return arg0.invoke();
		}
		session.put("tip", "您还没有登录，请登录");
		return "login";
	}
	
}
