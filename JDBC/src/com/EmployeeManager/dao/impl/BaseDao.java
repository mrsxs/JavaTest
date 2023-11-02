package com.EmployeeManager.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作基类，封装了公共的增删改查方法
 */
public class BaseDao {
    private static final String URL = "jdbc:mysql://1.94.15.19:8083/EmployeeManager?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "3100880856";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    protected Connection conn;

    protected PreparedStatement pstmt;
    protected ResultSet rs;

    /**
     * 获取数据库连接
     */
    public void getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库连接、预处理语句和结果集
     */
    public void closeAll() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 抽取公共的增删改方法
     * @param sql SQL语句
     * @param args SQL语句中的参数
     * @return 受影响的行数
     */
    public int update(String sql, Object... args) {
        int count = 0;
        this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return count;
    }


    /**
     * 抽取公共的查询方法
     * @param sql SQL语句
     * @param args SQL语句中的参数
     * @return 查询结果集
     */
    public ResultSet query(String sql, Object... args) {
        this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    pstmt.setObject(i + 1, args[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    /**
     * 判断表中是否存在指定数据
     * @param sql SQL语句
     * @param args SQL语句中的参数
     * @return 是否存在指定数据
     */
    public boolean isExist(String sql, Object... args) {
        this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    pstmt.setObject(i + 1, args[i]);
                }
            }
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return false; //表中没有这个数据
    }

}