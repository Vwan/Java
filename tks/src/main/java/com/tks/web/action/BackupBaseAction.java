package com.tks.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.tks.entity.GenericEntity;
import com.tks.service.impl.AbstractGenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.json.JSONInterceptor;
import org.apache.struts2.json.annotations.JSON;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by wanjia on 2016/8/21.
 */
@ParentPackage("json-default")
@InterceptorRefs({
        //  @InterceptorRef("modelDriven"),
        @InterceptorRef("exception"),
        @InterceptorRef(value = "json"),//,params = {"enableSMD","true"}),
        @InterceptorRef(value = "defaultStack"),//,params = {"modelDriven.refreshModelBeforeResult","true"}),
        // @InterceptorRef("jsonValidationWorkflowStack"),
        @InterceptorRef("multiselect")

})

@ExceptionMappings({
        @ExceptionMapping(exception = "java.lang.Exception", result = "error")
})
@Results({
        @Result(name = "error", type = "json", params = {"root", "exception", "statusCode", "500","ignoreHierarchy", "false" ,"noCache","true"}),
        @Result(name="success",type = "json", params = { "root","action","statusCode", "200","ignoreHierarchy", "false" ,"noCache","true"})
})
public abstract class BackupBaseAction<T extends GenericEntity,S extends AbstractGenericService> extends ActionSupport implements Preparable{//implements ModelDriven<T> {
    T entity;
    S service;
    String message;
    List<T> entities=new ArrayList<T>();
    protected List<String> listSelected = new ArrayList<String>();
    //protected Map<String, Object> datamap = new HashMap<>();

    private static final Logger LOG = LogManager.getLogger(BaseAction.class);

    public BackupBaseAction(){
        try {
            entity = (T) ((Class) ((ParameterizedType) this.getClass().
                    getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void prepare() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        String requestIp = request.getRequestURI();
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpSession session = request.getSession();
        ServletContext application = ServletActionContext.getServletContext();
        response.setHeader("Cache-Control", "private, no-cache");
        response.setHeader("Pragma", "no-cache");
        System.out.println("request ip:"+requestIp);
        System.out.println("response:"+response);
        System.out.println("session:"+session);
        System.out.println("application"+application);

    }

    @Action(value = "create"
            ,exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = "error")
    },
            results = {
                    @Result(name = "error", type = "json", params = {"root", "exception", "statusCode", "500","ignoreHierarchy", "false" ,"noCache","true"}),
                    @Result(name="success",type = "json", params = { "root","action","includeProperties","entity,message","statusCode", "200","ignoreHierarchy", "false" ,"noCache","true"})
            }

    )
    public String create(){

      /*  ValueStack vs = ActionContext.getContext().getValueStack();
        System.out.println(vs.getRoot().toString());
        String name = (String)vs.findValue("entity");
        System.out.println("name in value stack: "+name);*/
        System.out.println("create - message is:"+message);
        // System.out.println("create - entity is:"+entity.getClass());
        System.out.println("create - entity is:"+(T)entity);
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

    }

    public  long doCreate(){
        System.out.println("entity is" + entity);
        long id=service.create(entity);
        return id;
    }

    @Action(value = "listAll"
            ,exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = "error")}
            ,
            results = {
                    @Result(name = "error", type = "json", params = {"root", "exception", "statusCode", "500","ignoreHierarchy", "false" ,"noCache","true"}),
                    @Result(name="success",type = "json", params = { "root","action","excludeProperties","entity,service","statusCode", "200","ignoreHierarchy", "false" ,"noCache","true"})
            }

    )
    public String listAll(){
        System.out.println("before listAll: entities is: "+entities);
        entities=doListAll();
        System.out.println("after listAll: entities is: "+entities);
        if (entities==null){
            message="No Results Found";
            return ERROR;
        }
        System.out.println("listAll - "+entities);
        message="All Retrieved";
        return SUCCESS;
    }

    public List<T> doListAll(){
        return service.findAll();
    }

    @Action(value = "deleteEntity"
            ,exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = "error")
    }
    )
    public String deleteEntity(){

        try {
            System.out.println("delete - entity ID: "+entity.getId());
            T existingEntity = (T)service.findById(entity.getId());
            System.out.println("delete - entity : "+existingEntity);
            if (existingEntity!=null) {
                System.out.println("delete - entity: " + existingEntity);
                service.delete(existingEntity);
                message = "Deleted Successfully";
                return SUCCESS;
            } else {
                message = "Deletion Fail, please check log for details";
                return ERROR;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return ERROR;
    }

    @Action(value = "delete"
            ,exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = "error")
    })
    public String delete(){
        try {
            System.out.println("delete - entity ID: "+entity.getId());
            T existingEntity = (T)service.findById(entity.getId());
            System.out.println("delete - entity : "+existingEntity);
            if (existingEntity!=null) {
                System.out.println("delete - entity: " + existingEntity);
                service.delete(existingEntity);
                message = "Deleted Successfully";
                return SUCCESS;
            } else {
                message = "Deletion Fail, please check log for details";
                return ERROR;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return ERROR;
    }

    @Action(value = "batchdelete"
            ,exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = "error")
    })
    public String deleteBatch(){

        HttpServletRequest request = ServletActionContext.getRequest();
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()){
            String id = params.nextElement();
            System.out.println("params list: "+params.nextElement());
            try {
                System.out.println("delete - entity ID: "+id);
                List<T> toBeDeleted = new ArrayList<T>();
                toBeDeleted.add((T)service.findById(Long.parseLong(id)));
                System.out.println(toBeDeleted);
                message = "Deleted Successfully";
                return SUCCESS;

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        message = "Deletion Fail, please check log for details";
        return ERROR;
    }

    @Action(value = "update"
            ,exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = "error")
    })
    public String update(){
        System.out.println("updateentity - entity ID: "+entity.getId());
        long id = service.update(entity);
        System.out.println("id is:"+id);
        T existingEntity=(T)service.findSingleByFieldName("id",String.valueOf(id));
        System.out.println(existingEntity);
        if(existingEntity==null) {
            message = "Not Exists!";
            return ERROR;
        }
        message="Updated Successfully";
        return SUCCESS;
    }

    @Action("execute")
    public String execute(){
        return null;
    }

    @Override
    public void validate() {
        if (hasFieldErrors()) {
            addActionError("Errors present!");
        }
        addActionMessage(message);

    }

    @JSON
    public T getEntity() {

        System.out.println("entity in base action: "+entity);
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public S getService() {
        return service;
    }

    public void setService(S service) {
        this.service = service;
    }

    /* @Override
     public T getModel() {
         return entity;
     }*/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    public List<String> getListSelected() {
        return listSelected;
    }

    public void setListSelected(List<String> listSelected) {
        this.listSelected = listSelected;
    }

}

