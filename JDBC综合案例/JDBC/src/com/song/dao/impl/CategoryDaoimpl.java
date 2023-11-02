package com.song.dao.impl;

import com.song.dao.CategoryDao;
import com.song.entity.Category;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 分类的数据库操作类
 * 
 * @author song
 */

public class CategoryDaoimpl extends BaseDao implements CategoryDao {

    /**
     * 添加分类
     * 
     * @param category 分类对象
     * @return 返回受影响的行数
     */
    @Override
    public int addCategory(Category category) {
        int count;
        try {
            super.getConnection();
            // sql语句
            String sql = "insert into Category values(?,?)";
            // 参数
            Object[] params = { category.getCategoryId(), category.getCategoryName() };
            // 调用父类的方法
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 返回受影响的行数
        return count;
    }

    /**
     * 删除分类
     * @param categoryId 分类id
     * @return 返回受影响的行数
     */
    @Override
    public int deleteCategory(int categoryId) {
        // 受影响的行数
        int count = 0;
        try {
            super.getConnection();
            // sql语句
            String sql = "delete from Category where categoryId = ?";
            // 参数
            Object[] params = { categoryId };
            // 调用父类的方法
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
 // 返回受影响的行数
        return count;
    }

    /**
     * 修改分类
     * @param category 分类对象
     * @return 返回受影响的行数
     */
    @Override
    public int updateCategory(Category category) {
        // 受影响的行数
        int count = 0;
        try {
            super.getConnection();
            // sql语句
            String sql = "update Category set categoryName = ? where categoryId = ?";
            // 参数
            Object[] params = { category.getCategoryName(), category.getCategoryId() };
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return count;
    }

    /**
     * 查询所有分类
     * @return 返回分类集合
     */
    @Override
    public List<Category> queryCategory() {
        List<Category> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句
            String sql = "select * from Category";
            ResultSet resultSet = super.executeQuery(sql);
            // 遍历结果集
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setCategoryName(resultSet.getString("categoryName"));
                list.add(category);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        // 返回结果集
        return list;
    }

    /**
     * 模糊查询
     * @param categoryName 分类名
     * @return 返回分类集合
     */
    @Override
    public List<Category> queryCategory(String categoryName) {
        List<Category> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句模糊查询
            String sql = "select * from Category where CategoryName like ?";
            Object[] params = { "%" + categoryName + "%" };
            ResultSet resultSet = super.executeQuery(sql, params);
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("CategoryId"));
                category.setCategoryName(resultSet.getString("CategoryName"));
                list.add(category);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        return list;
    }

    /**
     * 判断有没有这个id
     * @param categoryId 分类id
     * @return 返回布尔值
     */
    @Override
    public boolean isExist(int categoryId) {
        boolean flag = false;
        try {
            super.getConnection();
            //sql语句 查询指定id的数据
            String sql = "select * from Category where categoryId = ?";
            //参数
            Object[] params = { categoryId };
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        //返回布尔值
        return flag;
    }

    /**
     * 根据id查询分类
     *
     * @param categoryId 分类id
     * @return 返回分类对象
     */
    @Override
    public Category queryCategoryById(int categoryId) {
        Category category = null;
        try {
            super.getConnection();
            String sql = "select * from Category where categoryId = ?";
            Object[] params = { categoryId };
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                category = new Category();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setCategoryName(resultSet.getString("categoryName"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        return category;
    }
}
