package com.tks.web.action;


import com.tks.entity.Language;
import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.entity.User;
import com.tks.service.impl.LanguageService;
import com.tks.service.impl.ProductService;
import com.tks.service.impl.ReleaseService;
import com.tks.service.impl.UserService;
import org.apache.struts2.convention.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wanjia on 2016/8/1.
 */
@Namespace("/user")
public class UserAction extends BaseAction<User,UserService> //extends ActionSupport//
{
    //User entity;

    public UserAction(){
        service = new UserService();
    }

    @Action(value = "assignToProduct"
            ,exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = "error")
    },
            results = {
                    @Result(name = "error", type = "json", params = {"root", "exception", "statusCode", "500","ignoreHierarchy", "false" ,"noCache","true"}),
                    @Result(name="success",type = "json", params = { "root","action","includeProperties","entity,message","statusCode", "200","ignoreHierarchy", "false" ,"noCache","true"})
            },
            interceptorRefs = {
                    @InterceptorRef(value = "json"),
                    @InterceptorRef(value = "defaultStack")
            }

    )
    public String assignToProduct() {

        System.out.println("assignProduct - user in user action:"+entity);
        System.out.println("selected product list is:"+listSelected);
        Set<Product> products = new HashSet<Product>() ;
        for(int i=0;i<listSelected.size();i++){
            products.add(new ProductService().findSingleByFieldName("name",listSelected.get(i)));
        }
        System.out.println("product list is:"+products);
        System.out.println(entity.getProducts());
        entity.setProducts(products);
        System.out.println("entity is:"+entity);
        long id =service.update(entity);
        User existingEntity=(User)service.findSingleByFieldName("id",String.valueOf(id));
        System.out.println(existingEntity);
        if(existingEntity==null) {
            message = "Not Exists!";
            return ERROR;
        }
        message="Updated Successfully";
        return SUCCESS;
    }


    /*
    public String create(){
        /*  ValueStack vs = ActionContext.getContext().getValueStack();
        System.out.println(vs.getRoot().toString());
        String name = (String)vs.findValue("entity");
        System.out.println("name in value stack: "+name);
        System.out.println("create - message is:"+message);
        // System.out.println("create - entity is:"+entity.getClass());
        System.out.println("create - entity is:"+(User)entity);
        //long id=service.create(entity);
        long id=doCreate();
        System.out.println("create - new id is:"+id);
        if (id>0) {
            message="Added Successfully: " + id;
            //  addActionMessage("Added Successfully: "+id);
            return SUCCESS;
        }
        else {
            message="Creation Fail,please check logs";
            return ERROR;
        }


    }*/





    public User getEntity(){

        System.out.println("getEntity in UserAction is executed: entity="+entity);
        return entity;
    }

    public void setEntity(User user) {
        System.out.println("setEntity in UserAction is executed: user= "+user);
        this.entity = user;
        System.out.println("setEntity in UserAction is executed: entity="+entity);
    }

    public List<User> getEntities(){
        System.out.println("getEntities in UserAction is executed: user= "+entities);
        return entities;
    }

    public void setEntities(List<User> users) {
        System.out.println("setEntities in UserAction is executed: user= "+users);
        entities= users;
        System.out.println("setEntities in UserAction is executed: entity="+entities);
    }
  /*  @Override
    public User getModel(){
        return (User)entity;
    }
*/
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
