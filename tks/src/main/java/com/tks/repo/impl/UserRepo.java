package com.tks.repo.impl;

import com.tks.entity.Language;
import com.tks.entity.User;
import com.tks.exception.CustomException;

/**
 * Created by wanjia on 2016/7/30.
 */
public class UserRepo extends GenericRepo<User> {
    public boolean exists(User user){
        if (user.getName()==null || user.getPassword()==null){
            throw new CustomException("User Name is empty","400");
        }
        return (findSingleByFieldName("name",user.getName())==null?false:true);
    }
}
