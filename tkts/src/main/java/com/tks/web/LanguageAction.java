package com.tks.web;

import com.tks.entity.Language;
import com.tks.service.impl.LanguageService;

/**
 * Created by wanjia on 2016/8/1.
 */
public class LanguageAction extends BaseAction<Language,LanguageService>{

    public LanguageAction(){
        service = new LanguageService();
    }


}
