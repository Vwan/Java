package com.tks.web;

import com.opensymphony.xwork2.ModelDriven;
import com.tks.entity.Status;
import com.tks.repo.impl.StatusRepo;
import com.tks.service.impl.StatusService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/8/1.
 */
public class StatusAction extends BaseAction<Status,StatusService> implements ModelDriven{
    private Status status;
    private List<Status> statuss;
    private Map<String, Object> statusmap = new HashMap<String,Object>();
    private StatusService statusService = new StatusService();
    private StatusRepo statusRepo = new StatusRepo();

    public StatusAction(){
        service = new StatusService();
    }
    public List<Status> getStatuss() {
      //  Statuss.add(new Status("Status1","desc1",new Status("s1","desc1")));
        return statuss;
    }

    public void setStatuss(List<Status> statuss) {
        this.statuss = statuss;
    }

    public String createStatus(){
        statusmap.clear();
        statusmap.put("success","true");
        long id=statusService.create(status);
        statusmap.put("id",id);
        System.out.println("result is: "+statusService.findSingleByFieldName("name",status.getName()));
        statusmap.put("Status",(Status)status);
        return SUCCESS;
    }


    public String listStatus(){
        statusmap.clear();
      //  statusmap.put("success","true");
        List<Status> statuses = statusService.findAll();
        statusmap.put("Status",statuses);
        return SUCCESS;
    }

    public String deleteStatus(){
        statusmap.clear();
        statusmap.put("success","true");
        System.out.println("deleteStatus - Status ID: "+status.getId());
        Status existingStatus = (Status)statusRepo.findById(status.getId());
        System.out.println("deleteStatus - Status: "+existingStatus);
    //    statusRepo.setEntity(existingStatus);
      //  statusService.setRepo(statusRepo);
        statusService.delete(existingStatus);
        return SUCCESS;
    }

    public String updateStatus(){
        statusmap.clear();
        statusmap.put("success","true");
        System.out.println("updateStatus - Status ID: "+status.getId());
        Status existingStatus = (Status)statusRepo.findById(status.getId());
       // statusRepo.setEntity(existingStatus);
        //statusService.setRepo(statusRepo);
        statusService.update(status);
       // System.out.println("result is: "+statusService.findByUniqueName("name",status.getName()));
        statusmap.put("Status",status);
        return SUCCESS;
    }
  //  @JSON(name="jsontest")
    public Map<String, Object> getStatusmap() {
        return statusmap;
    }

    public void setStatusmap(Map<String, Object> statusmap) {
        this.statusmap = statusmap;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Object getModel() {
        return status;
    }
}
