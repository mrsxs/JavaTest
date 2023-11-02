package com.song.dao;

import com.song.entity.Category;

import java.util.List;
/**
 * 分类的数据库操作类
 * 
 * @Author song
 */

public interface CategoryDao {

    /**
     * 添加分类
     * @param category 分类对象
     * @return 返回受影响的行数
     */
    public int addCategory(Category category);

    /**
     * 删除分类
     * @param categoryId 分类id
     * @return 返回受影响的行数
     */

    public int deleteCategory(int categoryId);

    /**
     * 修改分类
     * @param category 分类对象
     * @return 返回受影响的行数
     */
    public int updateCategory(Category category);

    /**
     * 查询所有分类
     * @return 返回分类集合
     * 
     */
    public List<Category> queryCategory();

    /**
     * 模糊查询
     * @param categoryName 分类名称
     * @return 返回分类集合
     */
    public List<Category> queryCategory(String categoryName);

    /**
     * 判断有没有这个id
     * @param categoryId 分类id
     * @return 返回布尔值
     */
    public boolean isExist(int categoryId);

    /**
     * 根据id查询分类
     * @param categoryId 分类id
     * @return 返回分类对象
     */
    public Category queryCategoryById(int categoryId);
}
