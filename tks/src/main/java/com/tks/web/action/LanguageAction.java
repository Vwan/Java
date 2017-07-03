package com.tks.web.action;

import com.tks.entity.Language;
import com.tks.entity.TaskStatus;
import com.tks.entity.User;
import com.tks.service.impl.LanguageService;
import org.apache.struts2.convention.annotation.Namespace;

import java.util.List;

/**
 * Created by wanjia on 2016/8/1.
 */

@Namespace("/lang")
public class LanguageAction extends BaseAction<Language,LanguageService>{

    public LanguageAction(){
        service = new LanguageService();
    }

    public Language getEntity(){
        return entity;
    }

    public void setEntity(Language item) {
        System.out.println("setEntity in UserAction is executed: user= "+item);
        this.entity = item;
        System.out.println("setEntity in UserAction is executed: entity="+entity);
    }

    public void setEntities(List<Language> items) {
        System.out.println("setEntity in UserAction is executed: user= "+items);
        entities= items;
        System.out.println("setEntity in UserAction is executed: entity="+entities);
    }

    public List<Language> getEntities(){
        return entities;
    }
}
