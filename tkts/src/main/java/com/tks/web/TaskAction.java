package com.tks.web;

import com.tks.entity.Release;
import com.tks.entity.Status;
import com.tks.entity.Task;
import com.tks.repo.impl.TaskRepo;
import com.tks.service.impl.TaskService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/8/1.
 */
public class TaskAction extends BaseAction<Task, TaskService>{
    private Task task;
    private List<Task> tasks;
    private Map<String, Object> taskmap = new HashMap<String,Object>();
    private TaskService taskService = new TaskService();
    private TaskRepo taskRepo = new TaskRepo();

    public TaskAction (){
        service=new TaskService();
    }
    public List<Task> getTasks() {
      //  tasks.add(new Task("task1","desc1",new Status("s1","desc1")));
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String createTask(){
        taskmap.clear();
        taskmap.put("success","true");
        //ServletActionContext.getRequest().
        doCreateTask(task);
        taskmap.put("task",task);
        taskmap.put("status_id",task.getStatus().getId());
        return SUCCESS;
    }

    public Task doCreateTask(Task task){
        System.out.println("createTask - task in task action:"+task);
        Status status = taskService.getStatusByTask(task);
        Release release=taskService.getReleaseByTask(task);
        task = new Task(task.getSummary(),task.getDescription(),release,status);
        taskService.create(task);
        return task;
    }

    public String deleteTask(){
        taskmap.clear();
        taskmap.put("success","true");
        //ServletActionContext.getRequest().
        Task t = taskService.findTaskByStatusRelease(task);
        taskService.delete(t);
        taskmap.put("task",t);
        return SUCCESS;
    }

    //  @JSON(name="jsontest")
    public Map<String, Object> getTaskmap() {
        return taskmap;
    }

    public void setTaskmap(Map<String, Object> taskmap) {
        this.taskmap = taskmap;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }


}
