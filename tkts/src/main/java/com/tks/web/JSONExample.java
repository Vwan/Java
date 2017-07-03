package com.tks.web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanjia on 2016/8/3.
 */
public class JSONExample extends ActionSupport{

    private String field1;
    private String field2;
    private String field3;

    private Map<String, String> map = new HashMap<String,String>();
    public String execute(){
        map.put("name","testjson");
        // if(getTasks()!=null)
        return SUCCESS;
        //  else return ERROR;
    }

    @JSON(name="jsontest")
    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
