package com.tks.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tks.entity.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.servlet.http.Cookie;

/**
 * Created by wanjia on 2016/8/1.
 */
@Namespace("/")
@Results({
@Result(name="success",location="index11.jsp"),
@Result(name="error",location="login.jsp")
})
public class LoginAction extends ActionSupport implements ModelDriven{
        private User user;
        private String msg;

        @Action("login")
        public String login() throws Exception {
            if("test".equals(user.getName())&&"test".equals(user.getPassword())){
                // get action context
                ActionContext context = ActionContext.getContext();
                // set up message
                context.getSession().put("user",user.getName());
                msg="Welcome " + user.getName();
            /**
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
            /**
            cookie
             */
                Cookie cookie = new Cookie("user",user.getName());
                cookie.setMaxAge(3600);
                ServletActionContext.getResponse().addCookie(cookie);
                 context.put("message","You have already logged in!");
                return SUCCESS;
            }else{
                msg=" error";
                return ERROR;
            }
        }

        public String register() {
            // to add insertion into db
            ActionContext.getContext().getSession().put("user", user.getName());
            msg = "Welcome " + user.getName() + ", You have successfully registered";
            return SUCCESS;
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

    @Override
    public User getModel() {
        return user;
    }

    public void validate(){
        if("".equals(user.getName())){
            addFieldError("name",getText("name.required"));
        }
        if("test".equals(user.getName()) & "test".equals(user.getPassword())){
            addActionError("Valid User");
        }else{
            addActionError("Invalid User or password");
        }
    }
}


