package com.tks.web.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.tks.entity.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

/**
 * Created by wanjia on 2016/8/1.
 */
@Namespace("/test")

public class TestAction extends BaseTestAction<User> {

    String json;


    public String getJson() {
        return json;
    }
   // StrutsRequestWrappers
    public void setJson(String json) {
        this.json = json;
    }

    public TestAction() {
      //  service = new UserService();
        //entity = new User();
    }

    public User getEntity(){
        System.out.println("getEntity in TestAction is executed: "+entity);
        return (User)entity;
    }
    public void setEntity(User user) {
        System.out.println("setEntity in TestAction is executed: "+entity);
        entity=user;

        System.out.println("setEntity in TestAction is executed: "+entity);
    }
    @Action(value = "create",className = "com.tks.web.action.TestAction")
    public String create() {
        ActionContext context = ServletActionContext.getContext();
        ValueStack vs = context.getValueStack();

       // vs.push("{\"entity\":{\"name\":\"test\"}");
       /* TestAction value = (TestAction)vs.peek();
        ResourceBundle rs = value.getTexts();
        System.out.println("rs is:"+rs);
        Set<String> keys = rs.keySet();
        for(String s:keys){
            System.out.println("S is:"+s);
        }*/
        System.out.println("user is:"+(User)entity);
        System.out.println("json is:"+json);
        return SUCCESS;
    }



  /*  @Action(value = "create",results = {
            @Result(name="success",type = "json"
                  //  ,params = { "root","user"
                 //   ,"contentType","application/json"
          //  }
            ) })*/
 /*   public String create(){
        datamap.clear();

        StringBuilder sb = new StringBuilder();
        HttpServletRequest request = ServletActionContext.getRequest();
        Enumeration<String> params = request.getParameterNames();
        try {
            ServletInputStream im = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)im));
            String line = null;
            while((line = br.readLine())!=null){
                sb.append(line);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(params.hasMoreElements()){
            System.out.println("params list: "+params.nextElement());
        }
        System.out.println(request.getParameterNames().toString());
        System.out.println("request url is: "+request.getRequestURL());
        JSONObject jo=new JSONObject(sb.toString());
        System.out.println(jo.toString());
        json=(String)jo.get("json");

        System.out.println("1create - json is:"+json);
        //long id=service.create(user);
        long id=doCreate();
        System.out.println("create - new id is:"+id);
        if (id>0) {
            datamap.put("success","true");
            datamap.put("message","Added Successfully");
            datamap.put("user", user);
            return SUCCESS;
        }
        else {
            datamap.put("success","false");
            datamap.put("message","Already exists");
            datamap.put("user","");
            System.out.println("result is:"+datamap.get("success"));

        }
        return ERROR;
    }

    public  long doCreate(){
        System.out.println("user is " + user);
        long id=0;
        if(user!=null)
            id=service.create(user);

        return id;
    }

    public List<User> doListAll(){
        return service.findAll();
    }

    public String listAll(){
        datamap.clear();
        users=doListAll();
        System.out.println("listAll - "+users);
        if(users!=null) {
            return SUCCESS;
        }
        else{
            return ERROR;
        }
    }

    public User getUser() {
        System.out.println("Get User executed");
        return user;
    }

    public void setUser(User user) {

        System.out.println("Set User executed");
        this.user = user;

        System.out.println("Set User executed: "+this.user);
    }

    public Map<String, Object> getDatamap() {
        return datamap;
    }

    public void setDatamap(Map<String, Object> datamap) {
        this.datamap = datamap;
    }

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    */
}
