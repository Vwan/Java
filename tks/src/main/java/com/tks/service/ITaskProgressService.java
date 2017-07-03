package com.tks.service;

import com.tks.core.ITaskProgressRepoService;
import com.tks.core.ITaskRepoService;
import com.tks.entity.Task;
import com.tks.entity.TaskProgress;
import com.tks.repo.impl.TaskProgressRepo;
import com.tks.repo.impl.TaskRepo;

/**
 * Created by wanjia on 2016/8/3.
 */
public interface ITaskProgressService extends IGenericService<TaskProgress,TaskProgressRepo>,ITaskProgressRepoService {


}
