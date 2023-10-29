package com.song.dao.impl;


import java.sql.*;

public class BaseDao {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //编码utf-8
    private static final String URL = "jdbc:mysql://1.94.15.19:8083/shopdb?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "3100880856";

    protected Connection conn;

    protected PreparedStatement pstmt;

    protected ResultSet rs;

    /**
     * 连接数据库
     */
    public void getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放资源
     */
    public void connClose() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通用的增删改
     *
     * @param sql
     * @param params
     */

    public int executeUpdate(String sql, Object... params) {
        getConnection();
        int result = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; ++i) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connClose();
        }
        return result;
    }

    /**
     * 通用的查询
     *
     * @param sql
     * @param params
     */
    public ResultSet executeQuery(String sql, Object... params) {
        getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; ++i) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    /**
     * 通用的查询
     *
     * @param sql
     */
    public ResultSet executeQuery(String sql) {
        getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

}
