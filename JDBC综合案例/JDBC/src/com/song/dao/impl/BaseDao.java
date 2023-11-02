package com.song.dao.impl;

import java.sql.*;

/**
 * 数据库操作的基类
 * 
 * @author song
 *
 * 
 */
public class BaseDao {
    /**
     * 数据库连接地址
     * 数据库驱动
     * 数据库用户名
     * 数据库密码
     */
    private static final String URL = "jdbc:mysql://1.94.15.19:8083/shopdb?useUnicode=true&characterEncoding=utf8";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "3100880856";
    /**
     * 数据库连接对象
     */
    protected Connection conn;
    /**
     * 数据库操作对象
     */

    protected PreparedStatement pstmt;
    /**
     * 数据库结果集对象
     */

    protected ResultSet rs;

    /**
     * 连接数据库
     */
    public void getConnection() {
        try {
            /**
             * 加载驱动
             */
            Class.forName(DRIVER);
            /**
             * 获取连接
             */
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
            /**
             * 关闭资源
             */
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
     * @param sql    SQL语句
     * @param params 参数列表
     * @return 受影响的行数
     */

    public int executeUpdate(String sql, Object... params) {
        /**
         * 获取连接
         */
        getConnection();
        int result = 0;
        try {
            /**
             * 创建操作对象
             */
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                /**
                 * 设置参数
                 */
                for (int i = 0; i < params.length; ++i) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            /**
             * 执行操作
             */
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connClose();
        }
        /**
         * 返回结果
         */
        return result;
    }

    /**
     * 通用的查询
     *
     * @param sql    SQL语句
     * @param params 参数列表
     * @return 查询结果
     */
    public ResultSet executeQuery(String sql, Object... params) {
        /**
         * 获取连接
         */
        getConnection();
        try {
            /**
             * 创建操作对象
             */
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; ++i) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            /**
             * 执行操作
             */
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /**
         * 返回结果
         */
        return rs;
    }

    /**
     * 通用的查询
     *
     * @param sql SQL语句
     * @return 查询结果
     */
    public ResultSet executeQuery(String sql) {
        /**
         * 获取连接
         */
        getConnection();
        try {
            /**
             * 创建操作对象
             */
            pstmt = conn.prepareStatement(sql);
            /**
             * 执行操作
             */
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /**
         * 返回结果
         */
        return rs;
    }

}
