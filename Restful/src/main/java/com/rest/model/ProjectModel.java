package com.rest.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rest.common.Log;
import com.rest.common.MySqlDBHandler;

public class ProjectModel {
	Log log = new Log();
	
    public ProjectModel()  {
     }
 
    public boolean createProject(Project p) throws SQLException{
    	boolean bl=projectExists(p.getId());
    	if (!bl){
	    	String sql = "insert into Projects values ("+(p.getId())+","+"\""+p.getName()+"\","+"\""+p.getDescription()+"\")";
	    	log.info(sql);
	    	if (MySqlDBHandler.excuteUpdate(sql)){
	    		bl=true;
	    	}
    	}
    	else {
    		log.info("Project " +p+ " already exists!");
    		bl=false;
    	}
    	return bl;
    }
   
    public boolean updateProject(Project p) throws SQLException{
    	String sql = "update Projects set Name="+"\""+p.getName()+"\",Description="+"\""+p.getDescription()+"\" where ID="+"\""+p.getId()+"\"";
    	System.out.println(sql);
    	if (MySqlDBHandler.excuteUpdate(sql)){
    		return true;
    	}
		//return sql;
		return false;
    }
    
    public boolean deleteRecord(int id) throws SQLException{
    	String sql = "delete from Projects where ID="+"\""+id+"\"";
    	System.out.println(sql);
    	if(MySqlDBHandler.excuteUpdate(sql)){return true;}
    	return false;
    }
    
    public List<Project> getProjects() throws SQLException{
    	ResultSet rs = MySqlDBHandler.executeQuery("select * from projects");
    	List<Project> list = new ArrayList<Project>();
        while (rs.next()) {
        	int p_id=rs.getInt("id");
        	String name=rs.getString("name");
        	String description=rs.getString("description");
             list.add(new Project(p_id,name,description));
        }
        return list;
    }
    
    public List<Project> getProjectsWithProductsByID(Integer id) throws SQLException{
    	List<Project> list = new ArrayList<Project>();
    	List<Product> listp= getProductsByProjectID(id);
    	ResultSet rs = MySqlDBHandler.executeQuery("select * from projects where id="+id);
        while (rs.next()) {
 
        	int pjid = rs.getInt("id");
        	String name = rs.getString("name");
        	String description=rs.getString("description");
        	
        	list.add(new Project(pjid,name,description,listp));
        	
        }
        return list;
    }
    
    public List<Project> getProjectByID(Integer id) throws SQLException{
    	ResultSet rs =  MySqlDBHandler.executeQuery("select * from projects where id="+id);
    	List<Project> list = new ArrayList<Project>();
        while (rs.next()) {
        	int p_id=rs.getInt("id");
        	String name=rs.getString("name");
        	String description=rs.getString("description");
             list.add(new Project(p_id,name,description));
        }
        return list;
    }
    
    public boolean projectExists(int id) throws SQLException{
    	if(getProjectByID(id).size()>0)    return true;
    	else return false;
    }
    
    public List<Product> getProductsByProjectID(int id) throws SQLException{
    	List<Product> listp = new ArrayList<Product>();
    	ResultSet rsp = MySqlDBHandler.executeQuery("select * from products where projid="+id);
    	while(rsp.next()){
        	int p_id=rsp.getInt("id");
        	String p_name=rsp.getString("name");
        	int projid=rsp.getInt("projid");
             listp.add(new Product(p_id,p_name,projid));
    	}
		return listp;
    }
 
}
