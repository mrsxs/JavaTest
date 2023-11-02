package com.song.test;

import com.song.dao.impl.EmployeeDaoimpl;

import java.util.Scanner;

import static com.song.util.CategoryFunction.categoryStart;
import static com.song.util.EmployeeFunction.employeeStart;
import static com.song.util.GoodsFunction.goodsStart;
import static com.song.util.OffersFunction.offersStart;
import static com.song.util.SalesFunction.salesStart;

/**
 * 商品管理系统的启动类
 * 
 * @Author song
 */

public class ShopdbTest {
    public static void main(String[] args) {
        printMenu();
    }

    /**
     * 打印菜单
     */
    public static void printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用商品管理系统");
        System.out.println("请输入你的用户名");
        String username = sc.next();
        System.out.println("请输入你的密码");
        String password = sc.next();
        // 等用户表建好后期加个判断用户名和密码是否正确
        boolean exist = new EmployeeDaoimpl().isExist(username, password);
        if (!exist) {
            System.out.println("用户名或密码错误");
            sc.close();
            return;

        }
        System.out.println("登录成功");
        System.out.println("请选择你要操作的表：1类别表 2职员数据表 3商品信息表 4供货商信息数据表 5销售信息表 6退出");
        int i = sc.nextInt();
        switch (i) {
            case 1:
                // 类别表
                categoryStart();
                break;
            case 2:
                // 职员数据表
                employeeStart();
                break;
            case 3:
                // 商品信息表
                goodsStart();
                break;
            case 4:
                // 供货商信息数据表
                offersStart();
                break;
            case 5:
                // 销售信息表
                salesStart();
                break;
            case 6:
                // 退出
                System.out.println("退出成功");
                break;
            default:
                System.out.println("输入的数字不在范围内 请重新输入");
        }
        sc.close();
    }
}
