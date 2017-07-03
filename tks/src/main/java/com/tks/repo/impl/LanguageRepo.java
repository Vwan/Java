package com.tks.repo.impl;

import com.tks.entity.Language;
import com.tks.exception.CustomException;

/**
 * Created by wanjia on 2016/7/30.
 */
public class LanguageRepo extends GenericRepo<Language> {
    public boolean exists(Language language){

        if (language.getCode()==null){
            throw new CustomException("Language Code is empty","400");
        }
        return (findSingleByFieldName("code",language.getCode())==null?false:true);
    }
}
