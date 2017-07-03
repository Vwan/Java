package com.rest.common;

public interface Constants {
	public static final String PORT="9898";
	public static final String BASEURI = "http://localhost:"+PORT+"/rest/";
	public static final String MYSQLURL = "jdbc:mysql://localhost:3306/REST?user=root&password=&useUnicode=true&characterEncoding=UTF8";
	public static final String TABLENAME = "Project";
	public static final String TABLESQL = "create table "
			+ TABLENAME
			+ " (projectName char(200),projectID varchar(20),primary key(projectID))";

}
