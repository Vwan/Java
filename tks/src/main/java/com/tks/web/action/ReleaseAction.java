package com.tks.web.action;

import com.tks.entity.*;
import com.tks.service.impl.LanguageService;
import com.tks.service.impl.ProductService;
import com.tks.service.impl.ReleaseService;
import org.apache.struts2.convention.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wanjia on 2016/8/1.
 */

@Namespace("/release")
public class ReleaseAction extends BaseAction<Release,ReleaseService>{

    //protected List<String> listSelected = new ArrayList<String>();
    public ReleaseAction(){
        service=new ReleaseService();
    }
    public long doCreate(){
        System.out.println("createRelease - Release in Release action:"+entity);
        System.out.println("selected list is:"+listSelected);
        Set<Language> langlist = new HashSet<Language>() ;
       /* listSelected.stream().forEach( (key)->
                langlist.add(new LanguageService().findSingleByFieldName("code",key))
        );*/
       /*Iterator it = listSelected.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            langlist.add(new LanguageService().findSingleByFieldName("code",it.next().toString()));
        }*/
       for(int i=0;i<listSelected.size();i++){
           langlist.add(new LanguageService().findSingleByFieldName("code",listSelected.get(i)));
       }
        System.out.println("language list is:"+langlist);
        entity.setLanguages(langlist);
        entity.setProduct(new ProductService().findSingleByFieldName("name",entity.getProduct().getName()));
        System.out.println("entity is:"+entity);
        long id =service.create(entity);
        return id;
    }
    public long doCreateOld(){
        System.out.println("createRelease - Release in Release action:"+entity);

        Set<Language> langlist = new HashSet<Language>() ;
        for(Language language:entity.getLanguages()){
            langlist.add(new LanguageService().findSingleByFieldName("code",language.getCode()));
        }
        entity.setLanguages(langlist);
        entity.setProduct(new ProductService().findSingleByFieldName("name",entity.getProduct().getName()));
        System.out.println("entity is:"+entity);
        long id =service.create(entity);
        return id;
    }
    @Action(value = "listAllByProduct",results = {
            @Result(type = "json",params = { "root", "entities" }) }

            ,exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = "error")
    },
            interceptorRefs = {
                   // @InterceptorRef(value = "json"),
                    @InterceptorRef(value = "defaultStack")
            })

    public String listAllByProduct(){
        System.out.println("Product Name is: "+entity.getProduct().getName());
        Product product = new ProductService().findSingleByFieldName("name",entity.getProduct().getName());
        entities=service.FindAllById("product_id",product.getId());
        System.out.println("listAll - "+entities);
        if(entities!=null) {
            return SUCCESS;
        }
        else{
            return ERROR;
        }
    }

    @Override
    public String toString() {
        return "ReleaseAction{}";
    }

    public Release getEntity(){
        return entity;
    }

    public void setEntity(Release item) {
        System.out.println("setEntity in UserAction is executed: user= "+item);
        this.entity = item;
        System.out.println("setEntity in UserAction is executed: entity="+entity);
    }

    public void setEntities(List<Release> items) {
        System.out.println("setEntity in UserAction is executed: user= "+items);
        entities= items;
        System.out.println("setEntity in UserAction is executed: entity="+entities);
    }

    public List<Release> getEntities(){
        return entities;
    }

   /* public List<String> getListSelected() {
        return listSelected;
    }

    public void setListSelected(List<String> listSelected) {
        this.listSelected = listSelected;
    }*/
}
