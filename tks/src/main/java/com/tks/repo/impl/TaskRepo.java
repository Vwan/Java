package com.tks.repo.impl;

import com.tks.core.ITaskRepoService;
import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.entity.TaskStatus;
import com.tks.entity.Task;
import com.tks.exception.CustomException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/7/30.
 */
public class TaskRepo extends GenericRepo<Task> implements ITaskRepoService {

    public boolean exists(Task task){
        if (task.getSummary()==null || task.getRelease()==null){
            throw new CustomException("Task is empty","400");
        }
        Map<String,String> fields = new HashMap<>();
        fields.put("summary",task.getSummary());
      /*  fields.put("release",String.valueOf(task.getRelease().getId()));
        System.out.println("query fields are: " + fields);
       return (findSingleByFieldNames(fields)==null?false:true);*/
        return (findSingleByFieldName("summary",task.getSummary())==null?false:true);
    }

    public List<Task> findByProduct(Product product) {
        return findListByFieldName("product",Long.toString(product.getId()));
    }
    public List<Task> findByStatus(TaskStatus taskStatus) {
        return findListByFieldName("taskStatus",Long.toString(taskStatus.getId()));
    }

    @Override
    public List<Task> findAllSubTasks(Task task) {
        return findListByFieldName("task",String.valueOf(task.getId()));
    }

    @Override
    public List<Task> findByRelease(Release release) {
       return findListByFieldName("release",Long.toString(release.getId()));
    }

    public List<Task> findByStatusName(String statusName) {
        TaskStatus taskStatus = new TaskStatusRepo().findSingleByFieldName("status_name",statusName);
        return findListByFieldName("taskStatus",String.valueOf(taskStatus.getId()));
    }

    public TaskStatus getStatusByTask(Task task) {
        String statusName =task.getTaskStatus().getName();
        System.out.println("getStatusByTask - taskStatus name is: " + statusName);
        TaskStatus taskStatus = new TaskStatusRepo().findSingleByFieldName("name",statusName);
        System.out.println("getStatusByTask - taskStatus is" + taskStatus);
        return taskStatus;
    }

    public Release getReleaseByTask(Task task) {
        String releaseName =task.getRelease().getName();
        System.out.println("getReleaseByTask - releaseName is " + releaseName);
        Release release = new ReleaseRepo().findSingleByFieldName("name",releaseName);
        System.out.println("getReleaseByTask - release is :" + release);
        return release;
    }

    public Task findTaskByStatusRelease(Task task) {
        System.out.println("task in task action:"+task);
        TaskStatus taskStatus = getStatusByTask(task);
        Release release=getReleaseByTask(task);
        task = new Task(task.getSummary(),task.getDescription(),release, taskStatus);
        System.out.println(task);
        Map<String,String> map = new HashMap<>();
        map.put("summary",task.getSummary());
        map.put("status_id",String.valueOf(task.getTaskStatus().getId()));
        map.put("release_id",String.valueOf(task.getRelease().getId()));
        task=new TaskRepo().findSingleByFieldNames(map);
        System.out.println("findTaskByStatusRelease - task before delete: " + task);
        return task;
    }

}
