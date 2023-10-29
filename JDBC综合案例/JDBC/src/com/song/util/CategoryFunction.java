package com.song.util;

import com.song.Test.ShopdbTest;
import com.song.dao.impl.CategoryDaoimpl;
import com.song.entity.Category;

import java.util.List;
import java.util.Scanner;

public class CategoryFunction {

    /**
     * 启动方法
     */
    public static void CategoryStart() {

        while (true) {
            System.out.println("请选择对类别数据表的操作：1添加 2修改 3删除 4多条件查询 5退出");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt() == false) {
                System.out.println("输入的不是数字 请重新输入");
            }
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    //添加方法
                    addCategory();
                    break;
                case 2:
                    //修改方法
                    updateCategory();
                    break;
                case 3:
                    //删除方法
                    deleteCategory();
                    break;
                case 4:
                    //多条件查询
                    queryCategory();
                    break;
                case 5:
                    //退出
                    System.out.println("退出成功");
                    ShopdbTest.printMenu();
                default:
                    System.out.println("输入的数字不在范围内 请重新输入");

            }
        }
    }

    /**
     * 多条件查询
     */
    private static void queryCategory() {
        CategoryDaoimpl categoryDaoimpl = new CategoryDaoimpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的类别名称 可以模糊查询");
        String categoryName = sc.next();
        List<Category> list = categoryDaoimpl.queryCategory(categoryName);
        if (list.size() == 0) {
            System.out.println("没有查询到数据");
        } else {
            System.out.println("类别id\t类别名称");
            for (Category category : list) {
                System.out.println(category.getCategoryId() + "\t" + category.getCategoryName());
            }
        }

    }


    /**
     * 删除方法
     */
    private static void deleteCategory() {
        CategoryDaoimpl categoryDaoimpl = new CategoryDaoimpl();
        System.out.println("请输入要删除的类别id");
        Scanner sc = new Scanner(System.in);
        int categoryId = sc.nextInt();
        boolean exist = categoryDaoimpl.isExist(categoryId);
        if (exist == false) {
            System.out.println("该id不存在 请重新输入");
            return;
        }
        int count = categoryDaoimpl.deleteCategory(categoryId);
        if (count > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 修改方法
     */
    private static void updateCategory() {
        CategoryDaoimpl categoryDaoimpl = new CategoryDaoimpl();
        System.out.println("请输入要修改的类别id");
        Scanner sc = new Scanner(System.in);
        int categoryId = sc.nextInt();
        boolean exist = categoryDaoimpl.isExist(categoryId);
        if (exist == false) {
            System.out.println("该id不存在 请重新输入");
            return;
        }
        System.out.println("请输入要修改的类别名称");
        String categoryName = sc.next();
        Category category = new Category(categoryId, categoryName);
        int count = categoryDaoimpl.updateCategory(category);
        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    /**
     * 添加方法
     */
    private static void addCategory() {
        CategoryDaoimpl categoryDaoimpl = new CategoryDaoimpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要添加的类别id");
        int categoryId = sc.nextInt();
        boolean exist = categoryDaoimpl.isExist(categoryId);
        if (exist) {
            System.out.println("该id已存在 请重新输入");
            return;
        }
        System.out.println("请输入要添加的类别名称");
        String categoryName = sc.next();
        Category category = new Category(categoryId, categoryName);

        int count = categoryDaoimpl.addCategory(category);
        if (count > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
}
