package com.tks.repo.impl;

import com.tks.entity.Language;
import com.tks.entity.TaskStatus;
import com.tks.exception.CustomException;

/**
 * Created by wanjia on 2016/7/30.
 */
public class TaskStatusRepo extends GenericRepo<TaskStatus> {
    public boolean exists(TaskStatus taskStatus){
        if (taskStatus.getName()==null){
        throw new CustomException("Task Status Name is empty","400");
    }
        return (findSingleByFieldName("name",taskStatus.getName())==null?false:true);
    }
}
