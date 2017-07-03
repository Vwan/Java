package com.rest.common;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MySqlDBHandler {
	static Connection conn;
	static Statement stmt ;
	
	public static void dbflow() throws ClassNotFoundException, SQLException{
	}
	public static void connectDB(String url) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();
        if(stmt!=null) {
       	 System.out.print("DB Connected");} else {
       	 System.out.println("DB Connection Failed");
        }
	}
	
	public static void disconnectDB() throws ClassNotFoundException, SQLException{
		conn.close();
	}
	
	public static void createTable(String sql, String tableName) throws SQLException{
		DatabaseMetaData dbm = conn.getMetaData();
		// check if "tableName" table is there
		ResultSet tables = dbm.getTables(null, null, tableName, null);
		if (!tables.next()) {
			stmt.executeUpdate(sql);
		}
	}
	
	public static boolean excuteUpdate(String sql) throws SQLException{
		int result= stmt.executeUpdate(sql);
		if (result>0) return true;
		else return false;
  }
	
	public static ResultSet executeQuery(String sql) throws SQLException{
	//	List<Project> list = new ArrayList<Project>();
		ResultSet rs = stmt.executeQuery(sql);
      /*  while (rs.next()) {
      	String projectName=rs.getString("projectName");
        	String projectID=rs.getString("projectID");
             list.add(new Project(projectName,projectID));
        }
        return list;*/
		return rs;
  }
	
	
}


