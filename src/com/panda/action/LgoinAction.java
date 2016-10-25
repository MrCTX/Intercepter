package com.panda.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.panda.bean.User;

/*
* @author MrC
* @date 2016年10月24日下午9:13:51
* @parameter
* @version
*/
@SuppressWarnings("serial")
public class LgoinAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String login() {
		//验证用户名和密码，若都为admin，则将用户名保存在session中
		if ("admin".equals(user.getName()) && "admin".equals(user.getPassword())) {
			ServletActionContext.getRequest().getSession().setAttribute("user", user.getName());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public User getModel() {
		return user;
	}
	
}
