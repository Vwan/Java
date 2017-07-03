package com.tks.repo.impl;

import com.tks.core.ITaskRepoService;
import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.entity.Status;
import com.tks.entity.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/7/30.
 */
public class TaskRepo extends GenericRepo<Task> implements ITaskRepoService {

    public List<Task> findByProduct(Product product) {
        return findListByFieldName("product",Long.toString(product.getId()));
    }
    public List<Task> findByStatus(Status status) {
        return findListByFieldName("status",Long.toString(status.getId()));
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
        Status status = new StatusRepo().findSingleByFieldName("status_name",statusName);
        return findListByFieldName("status",String.valueOf(status.getId()));
    }

    public Status getStatusByTask(Task task) {
        String statusName =task.getStatus().getName();
        System.out.println("getStatusByTask - status name is: " + statusName);
        Status status = new StatusRepo().findSingleByFieldName("name",statusName);
        System.out.println("getStatusByTask - status is" + status);
        return status;
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
        Status status = getStatusByTask(task);
        Release release=getReleaseByTask(task);
        task = new Task(task.getSummary(),task.getDescription(),release,status);
        System.out.println(task);
        Map<String,String> map = new HashMap<>();
        map.put("summary",task.getSummary());
        map.put("status_id",String.valueOf(task.getStatus().getId()));
        map.put("release_id",String.valueOf(task.getRelease().getId()));
        task=new TaskRepo().findSingleByFieldNames(map);
        System.out.println("findTaskByStatusRelease - task before delete: " + task);
        return task;
    }
}
