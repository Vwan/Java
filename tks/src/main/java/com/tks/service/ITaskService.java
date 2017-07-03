package com.tks.service;

import com.tks.core.ITaskRepoService;
import com.tks.entity.Task;
import com.tks.repo.impl.TaskRepo;

/**
 * Created by wanjia on 2016/8/3.
 */
public interface ITaskService extends IGenericService<Task,TaskRepo>,ITaskRepoService {


}
