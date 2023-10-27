package com.song.dao;

import com.song.entity.Category;

import java.util.List;

public interface CategoryDao {
    
        /**
        * 添加分类
        */
        public int addCategory(Category category);
    
        /**
        * 删除分类
        */
    
        public int deleteCategory(int categoryId);
    
        /**
        * 修改分类
        */
        public int updateCategory(Category category);
    
        /**
        * 查询所有分类
        */
        public List<Category> queryCategory();

        /**
         * 模糊查询
         */
        public List<Category> queryCategory(String categoryName);

        /**
         * 判断有没有这个id
         */
        public boolean isExist(int categoryId);
}
