package com.tks.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;

/**
 * Created by wanjia on 16/10/19.
 */
@ParentPackage("json-default")
@InterceptorRefs({
        @InterceptorRef(value = "json"),
        @InterceptorRef(value = "defaultStack"),

})
/*@ExceptionMappings({
        @ExceptionMapping(exception = "java.lang.Exception", result = "error")
})*/
@Results({
    //    @Result(name = "error", type = "json", params = {"root", "exception", "statusCode", "500","ignoreHierarchy", "false" ,"noCache","true"}),
        @Result(name="success",type = "json", params = { "root","action","statusCode", "200","ignoreHierarchy", "false" ,"noCache","true"})
})
public class BaseTestAction<T> extends ActionSupport implements ModelDriven<T> {
    protected T entity;

    public BaseTestAction(){

    }
 /*   @Override
    public T getModel() {
        return (T)entity;
    }
*/
    public T getEntity() {
        System.out.println("getEntity in BaseTestAction is executed: "+entity);
        return entity;
    }

    public void setEntity(T entity) {
        System.out.println("setEntity in BaseTestAction is executed: "+entity);
        this.entity = entity;
    }

    @Override
    public T getModel() {
        return entity;
    }
}
