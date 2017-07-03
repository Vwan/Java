package com.tks.service.impl;

import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.entity.TaskStatus;
import com.tks.entity.Task;
import com.tks.repo.impl.TaskRepo;
import com.tks.service.ITaskService;

import java.util.List;

@SuppressWarnings("unchecked")
public class TaskService extends AbstractGenericService<Task,TaskRepo> implements ITaskService {
    private TaskRepo taskRepo;

    public TaskService(){}
    @Override
    public List<Task> findByProduct(Product product) {
        return taskRepo.findByProduct(product);
    }

    @Override
    public List<Task> findByStatus(TaskStatus taskStatus) {
        return taskRepo.findByStatus(taskStatus);
    }
    public List<Task> findAllSubTasks(Task task){
        return repo.findAllSubTasks(task);
    }

    @Override
    public List<Task> findByRelease(Release release) {
        return repo.findByRelease(release);
    }

    @Override
    public TaskStatus getStatusByTask(Task task) {
        return repo.getStatusByTask(task);
    }

    @Override
    public Release getReleaseByTask(Task task) {
        return repo.getReleaseByTask(task);
    }

    @Override
    public Task findTaskByStatusRelease(Task task) {
        return repo.findTaskByStatusRelease(task);
    }

    public TaskRepo getTaskRepo() {
        return taskRepo;
    }

    public void setTaskRepo(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }
}
