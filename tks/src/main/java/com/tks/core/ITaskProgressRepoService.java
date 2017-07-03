package com.tks.core;

import com.tks.entity.Task;
import com.tks.entity.TaskProgress;

import java.util.List;

/**
 * Created by wanjia on 16/10/7.
 */
public interface ITaskProgressRepoService {

    List<TaskProgress> findByTask(Task task);
}
