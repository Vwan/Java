package com.hp.struts;

import java.util.Map;

public class LoginAction implements Action{
	private String errMsg;
	private User user;
	private Map<String,User> users;
	 public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute(){//页面提交后默认执行的方法
	     if("test".equals(user.getUsername())&&"test".equals(user.getPassword())){
	         return SUCCESS;
	     }else{
	         errMsg=" invalid";
	         return ERROR;
	     }
	 }  
	
	public String login(){//页面提交后默认执行的方法
	     if("test1".equals(getUsers().get("one").getUsername())&&"test1".equals(getUsers().get("one").getPassword())){
	         return SUCCESS;
	     }else{
	         errMsg=" invalid";
	         return ERROR;
	     }
	 }  
}
