package com.g11n.bookstore.common;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 16-5-3.
 */
public class ConnectionManager {
    private final static ThreadLocal<Connection> LOCAL= new ThreadLocal<Connection>();
    private static DataSource datasource;

    public static void setDataSource(DataSource datasource){
        ConnectionManager.datasource=datasource;
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = LOCAL.get();
        if (conn!=null){
            return conn;
        }
        conn = datasource.getConnection();
        LOCAL.set(conn);
        return conn;
    }

    public static void release(){
        Connection conn = LOCAL.get();
       // if (null!=conn) DBUtil.release(conn);
        LOCAL.remove();
    }
}
