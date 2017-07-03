package com.tks.service.impl;

import com.tks.entity.*;
import com.tks.repo.impl.TaskProgressRepo;
import com.tks.repo.impl.TaskRepo;
import com.tks.service.ITaskProgressService;
import com.tks.service.ITaskService;

import java.util.List;

@SuppressWarnings("unchecked")
public class TaskProgressService extends AbstractGenericService<TaskProgress,TaskProgressRepo> implements ITaskProgressService {
    private TaskProgressRepo taskProgressRepo;

    public TaskProgressService(){}

    @Override
    public List<TaskProgress> findByTask(Task task) {
        return taskProgressRepo.findByTask(task);
    }

    public TaskProgressRepo getTaskProgressRepo() {
        return taskProgressRepo;
    }

    public void setTaskProgressRepo(TaskProgressRepo taskProgressRepo) {
        this.taskProgressRepo = taskProgressRepo;
    }
}
