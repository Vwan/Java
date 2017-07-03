package com.tks.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tks.entity.User;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class LoginAction_old extends ActionSupport implements ServletResponseAware{
	private User user;
	private String msg;
    /*
    Access httpServeletResponse
     */
    private HttpServletResponse response;
    public void setServletResponse(HttpServletResponse response){
        this.response=response;
    }

	@Override
	public String execute() throws Exception {
		if("test".equals(user.getName())&&"test".equals(user.getPassword())){
			// get action context
			ActionContext context = ActionContext.getContext();
			// set up message
			context.getSession().put("user",user.getName());
			msg="Welcome " + user.getName();
            /*
            calculate counter
             */
			Integer counter=(Integer) context.getApplication().get(("counter"));
			if(counter==null){
				counter=1;
			}
			else{
				counter=counter+1;
			}
			context.getApplication().put("counter",counter);
            /*
            cookie
             */
			Cookie cookie = new Cookie("user",user.getName());
			cookie.setMaxAge(3600);
			//ServletActionContext.getResponse().addCookie(cookie); same as below but even simle, as it doesn't need any implementation
			response.addCookie(cookie);
			context.put("message","You have already logged in!");
			return SUCCESS;
		}else{
			msg=" error";
			return ERROR;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
