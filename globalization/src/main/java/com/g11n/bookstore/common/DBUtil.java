package com.g11n.bookstore.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 16-5-3.
 */
public class DBUtil {
    public static void release(ResultSet rs) throws SQLException {
        if (rs != null) {
            release(rs.getStatement());
            rs.close();
        }
    }

    private static void release(Statement statement) throws SQLException {
        statement.close();
    }
    private static void release(Connection conn) throws SQLException {
        conn.close();
    }
}
