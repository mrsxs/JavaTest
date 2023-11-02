package com.song.entity;
/**
 * 分类实体类
 * @author song
 */

public class Category {

    /**
     * 分类id
     */
    private int categoryId; 
    /**
     * 分类名称
     */
    private String categoryName; 

    /**
     * 无参构造方法
     */
    public Category() {
    }

    /**
     * 有参构造方法
     * @param categoryId 分类id
     * @param categoryName 分类名称
     */ 
    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    /**
     * 获取
     * @return categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * 设置
     * @param categoryId
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取
     * @return categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String toString() {
        return "Category{categoryId = " + categoryId + ", categoryName = " + categoryName + "}";
    }
}
