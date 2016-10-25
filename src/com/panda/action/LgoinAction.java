package com.panda.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.panda.bean.User;

/*
* @author MrC
* @date 2016��10��24������9:13:51
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
		//��֤�û��������룬����Ϊadmin�����û���������session��
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
