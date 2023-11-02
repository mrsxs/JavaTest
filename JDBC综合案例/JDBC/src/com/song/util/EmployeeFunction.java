package com.song.util;

import com.song.dao.impl.EmployeeDaoimpl;
import com.song.entity.Employee;
import com.song.test.ShopdbTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 职员的功能类
 * 
 * @Author song
 */
public class EmployeeFunction {

    /**
     * 打印菜单
     */
    public static void employeeStart() {
        System.out.println("欢迎使用职员信息表");
        System.out.println("请选择你要进行的操作：1添加 2删除 3修改 4查询 5多条件查询");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                // 添加
                addEmployee();
                break;
            case 2:
                // 删除
                deleteEmployee();
                break;
            case 3:
                // 修改
                updateEmployee();
                break;
            case 4:
                // 查询
                compoundQuery();
                break;
            case 5:
                // 退出返回主菜单
                System.out.println("退出成功");
                ShopdbTest.printMenu();

                break;
            default:
                System.out.println("输入的数字不在范围内 请重新输入");
        }
        sc.close();
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
            sc.close();
            return;
        }
        int count = employeeDaoimpl.deleteEmployee(id);
        if (count > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        sc.close();
    }

    /**
     * 多条件查询
     */
    private static void compoundQuery() {
        String name = null;
        String sex = null;
        Scanner sc = new Scanner(System.in);
        final String yesOption = "y";
        System.out.println("是否根据姓名查询 " + yesOption + "/n");
        String s = sc.next();
        if (s.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入姓名");
            name = sc.next();
        }
        System.out.println("是否根据性别查询 " + yesOption + "/n");
        String s1 = sc.next();
        if (s1.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入性别");
            sex = sc.next();
        }
        System.out.println("是否根据年龄范围查询" + yesOption + "/n");
        String s2 = sc.next();
        int age = 0;
        int age1 = 0;
        if (s2.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入开始年龄范围");
            age = sc.nextInt();
            System.out.println("请输入结束年龄范围");
            age1 = sc.nextInt();
        }
        System.out.println("是否根据入职时间范围查询");
        String s3 = sc.next();
        String hireLong = null;
        String hireLong1 = null;
        if (s3.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入开始入职时间范围");
            hireLong = sc.next();
            System.out.println("请输入结束入职时间范围");
            hireLong1 = sc.next();
        }
        System.out.println("是否根据薪资范围查询");
        String s4 = sc.next();
        int salary = 0;
        int salary1 = 0;
        if (s4.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入开始薪资范围");
            salary = sc.nextInt();
            System.out.println("请输入结束薪资范围");
            salary1 = sc.nextInt();
        }
        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        List<Employee> employees = employeeDaoimpl.compoundQuery(name, sex, age, age1, hireLong, hireLong1, salary,
                salary1);
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
            sc.close();
        }

    }

    /**
     * 修改职员信息
     */

    private static void updateEmployee() {
        Scanner sc = new Scanner(System.in);
        String name = null;
        String pwd = null;
        String sex = null;
        int age = 0;
        double salary = 0;
        final String yesOption = "y";
        System.out.println("请输入要修改的职员id");

        int id = sc.nextInt();
        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        boolean isExist = employeeDaoimpl.isExist(id);
        if (isExist == false) {
            System.out.println("输入的id不存在");
            sc.close();
            return;
        }
        System.out.println("是否修改姓名 y/n");
        String s = sc.next();
        if (s.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入新的姓名");
            name = sc.next();
        }
        System.out.println("是否修改密码 y/n");
        String s1 = sc.next();
        if (s1.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入新密码");
            pwd = sc.next();
            System.out.println("请在次输入新密码");
            String pwd1 = sc.next();
            if (pwd1.equals(pwd) == false) {
                System.out.println("两次密码不一致 ");
                sc.close();
                return;
            }
        }
        System.out.println("是否修改性别 y/n");
        String s2 = sc.next();
        if (s2.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入性别");
            sex = sc.next();
        }
        System.out.println("是否修改年龄 y/n");
        String s3 = sc.next();
        if (s3.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入年龄");
            age = sc.nextInt();
        }
        System.out.println("是否修改薪水 y/n");
        String s6 = sc.next();
        if (s6.equalsIgnoreCase(yesOption)) {
            System.out.println("请输入薪水");
            salary = sc.nextDouble();
        }
        Employee employee = new Employee(id, name, pwd, sex, age, salary);
        int count = employeeDaoimpl.updateEmployee(employee);
        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        sc.close();

    }

    /**
     * 添加职员信息
     */
    private static void addEmployee() {
        System.out.println("请输入职员姓名");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("请输入职员密码");
        String pwd = sc.next();
        System.out.println("请在次输入职员密码");
        String pwd1 = sc.next();
        if (!pwd1.equals(pwd)) {
            System.out.println("两次密码不一致 ");
            sc.close();
            return;
        }
        System.out.println("请输入性别");
        String sex = sc.next();
        final String male = "男";
        final String female = "女";
        if (!male.equals(sex) && !female.equals(sex)) {
            System.out.println("输入的性别不正确");
            sc.close();
            return;
        }
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        // 获取当前时间 格式 2020-01-01 12:12:12
        // 设置时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String hireLong = df.format(new Date());

        System.out.println("请输入薪资");
        int salary = sc.nextInt();
        Employee employee = new Employee(name, pwd, sex, age, hireLong, salary);
        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        int count = employeeDaoimpl.addEmployee(employee);
        if (count > 0) {
            System.out.println("添加成功");
            System.out.println("添加时间:" + hireLong);
        } else {
            System.out.println("添加失败");
        }
        sc.close();
    }

}
