package com.EmployeeManager.test;

import com.EmployeeManager.util.DeptTest;
import com.EmployeeManager.util.EmpTest;

import java.util.Scanner;

/**
 * 这是一个测试类，用于测试员工表和部门表的操作。
 */
public class EmployeeManagerTest {
    
    /**
     * 主方法，用于选择需要操作的表。
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeptTest deptTest = new DeptTest();
        EmpTest empTest = new EmpTest();
        while (true) {
            System.out.println("请选择需要操作的表1.员工表2.部门表");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    empTest.start(args);

                    break;
                case 2:
                    deptTest.start(args);
                    break;
                default:
                    System.out.println("输入有误");
            }
        }

    }
}
