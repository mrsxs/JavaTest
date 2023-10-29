package com.song.util;

import java.util.Scanner;

public class OffersFunction {

    /**
     * 打印菜单
     */
    public static void printMenu() {
        System.out.println("***************供货商信息管理系统***************");
        System.out.println("1.添加供货商信息");
        System.out.println("2.删除供货商信息");
        System.out.println("3.修改供货商信息");
        System.out.println("4.查询供货商信息");
        System.out.println("5.退出系统");
        System.out.println("**********************************************");
        System.out.println("请输入你的选择：");
        Scanner sc =new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                //添加供货商方法
                addOffers();


                break;
            case 2:
                //删除供货商信息
                break;
            case 3:
                //修改供货商信息
                break;
            case 4:
                //查询供货商信息
                break;
            case 5:
                //退出系统
                System.out.println("退出成功");
                return;
            default:
                System.out.println("输入的数字不在范围内 请重新输入");
        }
    }

    private static void addOffers() {
        System.out.println("请输入供货商编号：");
    }

}
