package com.panda.intercepter;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
* @author MrC
* @date 2016��10��24������9:27:25
* @parameter
* @version
*/
@SuppressWarnings("serial")
public class MyInterceter extends AbstractInterceptor {

	public String intercept(ActionInvocation arg0) throws Exception {
		//���ActionContextʵ��
		ActionContext context = arg0.getInvocationContext();
		//���ʵ���е�session
		Map<String, Object> session =  context.getSession();
		String name = (String) session.get("user");
		if (name != null && "admin".equals(name)) {
			return arg0.invoke();
		}
		session.put("tip", "����û�е�¼�����¼");
		return "login";
	}
	
}
