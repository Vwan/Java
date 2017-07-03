package com.tks.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tks.entity.User;
import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanjia on 2016/8/3.
 */
public class JSONAction extends ActionSupport{
    private User user;
    private Map<String,Object> datamap = new HashMap<String,Object>();
    public String execute(){
        User user=new User("Json","json","test@hotmail.com");
        JSONObject json=new JSONObject();
        json.put("success", true);
        json.put("user", user);
        System.out.println(json.toString());
        //ServletActionContext.getContext().getSession().put("json",json.toString());
        ServletActionContext.getRequest().setAttribute("json",json.toString());
        return SUCCESS;
    }

    public void doAction() throws IOException {
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        User user=new User("Json","json","test@hotmail.com");
        JSONObject json=new JSONObject();
        json.put("success", true);
        json.put("user", user);
        out.println(json.toString());
        out.flush();
        out.close();
    }

    public String jsonAction() throws IOException {
        datamap.clear();
        User user=new User("Json","json","test@hotmail.com");
        datamap.put("success","true");
        datamap.put("user",user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, Object> getDatamap() {
        return datamap;
    }

    public void setDatamap(Map<String, Object> datamap) {
        this.datamap = datamap;
    }
}
