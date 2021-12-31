package com.situ.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author snow1k
 * @date 2021/12/02
 */
public final class JdbcUtil {
    /**
     * 获取数据库连接
     * 
     * @param driver
     * @param jdbcUrl
     * @param user
     * @param password
     * @return
     */
    public static Connection getConnection(String driver, String jdbcUrl, String user, String password) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败，请检查后再试");
        }
    }

    /**
     * 关闭数据库连接
     * 
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
