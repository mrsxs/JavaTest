package com.song.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * BaseDao
 * @author song
 */
public class BaseDao {

    private final String Driver = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://1.94.15.19:8083/Movie?characterEncoding=utf-8&useUnicode=true";
    private final String USERNAME = "root";
    private final String PASSWORD = "3100880856";

    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

    /**
     * 获取数据库连接
     * 
     * @return
     */
    public void getConnection() {

        try {
            Class.forName(Driver);
            conn = java.sql.DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库连接
     */
    public void CloseAll() {

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用的修改方法
     */

    public int update(String sql, Object... params) {
        int count = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);

            }
            count = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    /**
     * 通用的查询方法
     */
    public ResultSet query(String sql, Object... params) {
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);

            }
            rs = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseAll();
        }

        return rs;
    }

    /**
     * 判断是否存在
     */
    public boolean isExist(String sql, Object... params) {
        boolean flag = false;

        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseAll();
        }
        return flag;
    }
}