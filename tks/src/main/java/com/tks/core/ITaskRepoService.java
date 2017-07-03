package com.tks.core;

import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.entity.TaskStatus;
import com.tks.entity.Task;

import java.util.List;

/**
 * Created by wanjia on 2016/9/1.
 */
public interface ITaskRepoService {
    /**
     * Find all tasks for specific Product
     * @param p product
     * @return list of tasks for specified product
     */
    List<Task> findByProduct(Product product) ;
    /**
     * Find all tasks with specific TaskStatus
     * @param p product
     * @return list of tasks with specified TaskStatus
     */
    List<Task> findByStatus(TaskStatus taskStatus);

    /**
     * Find all sub tasks for a given task;
     * @param task
     * @return
     */
    List<Task> findAllSubTasks(Task task);

    /**
     * Find all tasks for given release
     * @param release
     * @return
     */
    List<Task> findByRelease(Release release);

    /**
     * Get TaskStatus object for a given task
     * @param task
     * @return
     */
    public TaskStatus getStatusByTask(Task task);

    /**
     * Get Release object for a given task
     * @param task
     * @return
     */
    public Release getReleaseByTask(Task task);

    /**
     * Find tasks for given release and status combination
     * @param task
     * @return
     */

    public Task findTaskByStatusRelease(Task task);

}
