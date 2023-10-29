package com.song.dao.impl;

import com.song.dao.CategoryDao;
import com.song.entity.Category;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoimpl extends BaseDao implements CategoryDao {

    /**
     * 添加分类
     */
    public int addCategory(Category category) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "insert into Category values(?,?)";
            Object[] params = {category.getCategoryId(), category.getCategoryName()};

            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    /**
     * 删除分类
     */

    public int deleteCategory(int categoryId) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "delete from Category where categoryId = ?";
            Object[] params = {categoryId};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return count;
    }

    /**
     * 修改分类
     */
    public int updateCategory(Category category) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "update Category set categoryName = ? where categoryId = ?";
            Object[] params = {category.getCategoryName(), category.getCategoryId()};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return count;
    }

    /**
     * 查询所有分类
     */
    public List<Category> queryCategory() {
        List<Category> list =new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Category";
            ResultSet resultSet = super.executeQuery(sql);
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setCategoryName(resultSet.getString("categoryName"));
                list.add(category);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 模糊查询
     */
    @Override
    public List<Category> queryCategory(String categoryName) {
        List<Category> list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Category where CategoryName like ?";
            Object[] params = {"%" + categoryName + "%"};
            ResultSet resultSet = super.executeQuery(sql, params);
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("CategoryId"));
                category.setCategoryName(resultSet.getString("CategoryName"));
                list.add(category);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 判断有没有这个id
     */
    @Override
    public boolean isExist(int categoryId) {
        boolean flag = false;
        try {
            super.getConnection();
            String sql = "select * from Category where categoryId = ?";
            Object[] params = {categoryId};
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    /**
     * 根据id查询分类
     * @param categoryId
     * @return
     */
    public Category queryCategoryById(int categoryId) {
        Category category = null;
        try {
            super.getConnection();
            String sql = "select * from Category where categoryId = ?";
            Object[] params = {categoryId};
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                category = new Category();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setCategoryName(resultSet.getString("categoryName"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return category;
    }
}
