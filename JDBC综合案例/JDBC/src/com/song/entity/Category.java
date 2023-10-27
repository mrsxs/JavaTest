package com.song.entity;

public class Category {
    private int CategoryId;
    private String CategoryName;



    /**
     * 无参构造方法
     */
    public Category() {
    }
    /**
     * 有参构造方法
     * @param categoryId
     * @param categoryName
     */
    public Category(int categoryId, String categoryName) {
        CategoryId = categoryId;
        CategoryName = categoryName;
    }
    /**
     * get set 方法
     * @return
     */
    public int getCategoryId() {
        return CategoryId;
    }
    /**
     * get set 方法
     * @param categoryId
     */
    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }
    /**
     * get set 方法
     * @return
     */
    public String getCategoryName() {
        return CategoryName;
    }
    /**
     * get set 方法
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }




 


    
}
