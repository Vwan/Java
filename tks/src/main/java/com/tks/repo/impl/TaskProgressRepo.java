package com.tks.repo.impl;

import com.tks.core.ITaskProgressRepoService;
import com.tks.core.ITaskRepoService;
import com.tks.entity.*;
import com.tks.exception.CustomException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/7/30.
 */
public class TaskProgressRepo extends GenericRepo<TaskProgress> implements ITaskProgressRepoService {

    public List<TaskProgress> findByTask(Task task) {
        return findListByFieldName("task",Long.toString(task.getId()));
    }

    public boolean exists(TaskProgress taskProgress){
        if (taskProgress.getDetails()==null){
            throw new CustomException("Task Progress Details is empty","400");
        }
        return (findSingleByFieldName("name",taskProgress.getDetails())==null?false:true);
    }
}
