package com.song.util;

import com.song.Test.ShopdbTest;
import com.song.dao.impl.EmployeeDaoimpl;
import com.song.entity.Employee;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeFunction {


    /**
     * 打印菜单
     */
    public static void EmployeeStart() {
        System.out.println("欢迎使用职员信息表");
        System.out.println("请选择你要进行的操作：1添加 2删除 3修改 4查询 5多条件查询");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                //添加
                addEmployee();
                break;
            case 2:
                //删除
                deleteEmployee();
                break;
            case 3:
                //修改
                updateEmployee();
                break;
            case 4:
                //查询
                CompoundQuery();
                break;
            case 5:
                //退出返回主菜单
                System.out.println("退出成功");
                ShopdbTest.printMenu();


                break;
            default:
                System.out.println("输入的数字不在范围内 请重新输入");
        }
    }

    /**
     * 删除职员信息
     */
    private static void deleteEmployee() {
        System.out.println("请输入要删除的职员id");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        boolean isExist = employeeDaoimpl.isExist(id);
        if (isExist == false) {
            System.out.println("输入的id不存在");
            return;
        }
        int count = employeeDaoimpl.deleteEmployee(id);
        if (count > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 多条件查询
     */
    private static void CompoundQuery() {
        String name = null;
        String sex = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("是否根据姓名查询 y/n");
        String s = sc.next();
        if (s.equalsIgnoreCase("y")) {
            System.out.println("请输入姓名");
            name = sc.next();
        }
        System.out.println("是否根据性别查询 y/n");
        String s1 = sc.next();
        if (s1.equalsIgnoreCase("y")) {
            System.out.println("请输入性别");
            sex = sc.next();
        }
        System.out.println("是否根据年龄范围查询");
        String s2 = sc.next();
        int age = 0;
        int age1 = 0;
        if (s2.equalsIgnoreCase("y")) {
            System.out.println("请输入开始年龄范围");
            age = sc.nextInt();
            System.out.println("请输入结束年龄范围");
            age1 = sc.nextInt();
        }
        System.out.println("是否根据入职时间范围查询");
        String s3 = sc.next();
        String HireLong = null;
        String HireLong1 = null;
        if (s3.equalsIgnoreCase("y")) {
            System.out.println("请输入开始入职时间范围");
            HireLong = sc.next();
            System.out.println("请输入结束入职时间范围");
            HireLong1 = sc.next();
        }
        System.out.println("是否根据薪资范围查询");
        String s4 = sc.next();
        int Salary = 0;
        int Salary1 = 0;
        if (s4.equalsIgnoreCase("y")) {
            System.out.println("请输入开始薪资范围");
            Salary = sc.nextInt();
            System.out.println("请输入结束薪资范围");
            Salary1 = sc.nextInt();
        }
        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        List<Employee> employees = employeeDaoimpl.CompoundQuery(name, sex, age, age1, HireLong, HireLong1, Salary, Salary1);
        if (employees.size() == 0) {
            System.out.println("没有查询到数据");
        } else {
            System.out.println("查询到的数据如下");
            for (Employee employee : employees) {
                System.out.println(employee.getEmployeeId() + "\t"
                        + employee.getEmpName() + "\t"
                        + employee.getSex() + "\t"
                        + employee.getAge() + "\t"
                        + employee.getHireLong() +
                        "\t" + employee.getSalary());

            }
        }


    }


    /**
     * 修改职员信息
     */

    private static void updateEmployee() {
        Scanner sc = new Scanner(System.in);
        String name = null;
        String pwd = null;
        String Sex = null;
        int age = 0;
        String HireLong = null;
        double Salary = 0;
        System.out.println("请输入要修改的职员id");

        int id = sc.nextInt();
        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        boolean isExist = employeeDaoimpl.isExist(id);
        if (isExist == false) {
            System.out.println("输入的id不存在");
            return;
        }
        System.out.println("是否修改姓名 y/n");
        String s = sc.next();
        if (s.equalsIgnoreCase("y")) {
            System.out.println("请输入新的姓名");
            name = sc.next();
        }
        System.out.println("是否修改密码 y/n");
        String s1 = sc.next();
        if (s1.equalsIgnoreCase("y")) {
            System.out.println("请输入新密码");
            pwd = sc.next();
            System.out.println("请在次输入新密码");
            String pwd1 = sc.next();
            if (pwd1.equals(pwd) == false) {
                System.out.println("两次密码不一致 ");
                return;
            }
        }
        System.out.println("是否修改性别 y/n");
        String s2 = sc.next();
        if (s2.equalsIgnoreCase("y")) {
            System.out.println("请输入性别");
            Sex = sc.next();
        }
        System.out.println("是否修改年龄 y/n");
        String s3 = sc.next();
        if (s3.equalsIgnoreCase("y")) {
            System.out.println("请输入年龄");
            age = sc.nextInt();
        }
        System.out.println("是否修改薪水 y/n");
        String s6 = sc.next();
        if (s6.equalsIgnoreCase("y")) {
            System.out.println("请输入薪水");
            Salary = sc.nextDouble();
        }
        Employee employee = new Employee(id, name, pwd, Sex, age, Salary);
        int count = employeeDaoimpl.updateEmployee(employee);
        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }


    }

    /**
     * 添加职员信息
     */
    private static void addEmployee() {
        Console console = System.console();
        System.out.println("请输入职员姓名");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("请输入职员密码");
        String pwd = sc.next();
        System.out.println("请在次输入职员密码");
        String pwd1 = sc.next();
        if (pwd1.equals(pwd) == false) {
            System.out.println("两次密码不一致 ");
            return;
        }
        System.out.println("请输入性别");
        String Sex = sc.next();
        if (Sex.equals("男") == false && Sex.equals("女") == false) {
            System.out.println("输入的性别不正确");
            return;
        }
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        //获取当前时间 格式 2020-01-01 12:12:12
        //设置时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String HireLong = df.format(new Date());

        System.out.println("请输入薪资");
        int Salary = sc.nextInt();
        Employee employee = new Employee(name, pwd, Sex, age, HireLong, Salary);
        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        int count = employeeDaoimpl.addEmployee(employee);
        if (count > 0) {
            System.out.println("添加成功");
            System.out.println("添加时间:" + HireLong);
        } else {
            System.out.println("添加失败");
        }
    }
}
