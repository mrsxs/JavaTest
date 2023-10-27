package com.song.Test;

import com.song.util.CategoryFunction;

import java.util.Scanner;
public class ShopdbTest {
    public static void main(String[] args) {
    printMenu();
    }
    /**
     * 打印菜单
     */
    public  static void printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用商品管理系统");
        System.out.println("请输入你的用户名");
        String username = sc.next();
        System.out.println("请输入你的密码");
        String password = sc.next();
//等用户表建好后期加个判断用户名和密码是否正确
        System.out.println("请选择你要操作的表：1类别表 2职员数据表 3商品信息表 4供货商信息数据表 5销售信息表");
        int i = sc.nextInt();
       switch (i){
           case 1:
               //类别表
               CategoryFunction categoryFunction = new CategoryFunction();
               categoryFunction.start();
           case 2:
               //职员数据表
           case 3:
               //商品信息表
           case 4:
               //供货商信息数据表
           case 5:
               //销售信息表
           default:
               System.out.println("输入的数字不在范围内 请重新输入");
       }
    }
}
