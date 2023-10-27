package com.EmployeeManager.util;

import com.EmployeeManager.dao.impl.DeptDaoimpl;
import com.EmployeeManager.entity.Dept;

import java.util.List;
import java.util.Scanner;

public class DeptTest {
    
    /**
     * 员工管理系统主程序
     * @param args 程序参数
     */
    public static void start(String[] args) {
        DeptDaoimpl deptDaoimpl = new DeptDaoimpl();
        while (true) {
            int i = printHeader();
            switch (i) {
                case 1:
                    insert();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    select();
                    break;
                case 5:
                    selectID();
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误");
            }
        }
    }

    /**
     * 查询所有部门信息
     */
    private static void select() {
        DeptDaoimpl deptDaoimpl = new DeptDaoimpl();
        List<Dept> alldepts = deptDaoimpl.getAlldepts();
        System.out.println("部门编号\t部门名称\t部门所在地");
        for (Dept dept : alldepts) {
            System.out.println(dept.getDeptno() + "\t" + dept.getDname() + "\t" + dept.getLoc());
        }
    }

    /**
     * 根据部门编号查询部门信息
     */
    private static void selectID() {
        System.out.println("请输入部门编号");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false) {
            System.out.println("输入的不是整数");
            return;
        }
        int deptno = sc.nextInt();
        //判断部门门是否存在
        DeptDaoimpl deptDaoimpl = new DeptDaoimpl();
        boolean exist = deptDaoimpl.isExistdeptno(deptno);
        if (!exist) {
            System.out.println("输入的部门不存在");
            return;
        }
        List<Dept> deptList = deptDaoimpl.getById(deptno);
        System.out.println("部门编号\t部门名称\t部门所在地");
        for (Dept dept : deptList) {
            System.out.println(dept.getDeptno() + "\t" + dept.getDname() + "\t" + dept.getLoc());
        }
    }

    /**
     * 删除部门信息
     */
    private static void delete() {
        Scanner sc = null;
        while (true) {
            System.out.println("请输入要删除的部门编号");
            sc = new Scanner(System.in);
            if (sc.hasNextInt() == false) {
                System.out.println("输入的不是整数 重新输入");
            }
            break;
        }

        int deptno = sc.nextInt();
        DeptDaoimpl deptDaoimpl = new DeptDaoimpl();
        boolean exist = deptDaoimpl.isExistdeptno(deptno);
        if (!exist) {
            System.out.println("输入的部门不存在 无法删除");
            return;
        } else {
            boolean exisdept = deptDaoimpl.isExisdept(deptno);
            if (exisdept) {
                System.out.println("该部门存在员工");
                System.out.println("你确定要删除吗");
            }
            System.out.println("输入y确定 输入n取消");
            String str = sc.next();
            if (str.equals("y")) {
                int i = deptDaoimpl.deleteDept(deptno);
                if (i == 0) {
                    System.out.println("删除失败");
                }
                System.out.println("删除成功");
            } else if (str.equals("n")) {
                System.out.println("取消删除");
            }
        }
    }

    /**
     * 修改部门信息
     */
    public static void update() {
        DeptDaoimpl deptDaoimpl = new DeptDaoimpl();
        boolean exist = false;
        int deptno = 0;
        String deptName = null;
        String loc = null;
        System.out.println("请输入要修改的部门id");

        Scanner sc = new Scanner(System.in);
        deptno = sc.nextInt();
        exist = deptDaoimpl.isExistdeptno(deptno);

        if (!exist) {
            System.out.println("输入的部门不存在");
            return;
        } else {
            System.out.println("请输入要修改的部门名称 输入n不修改");
            String NewdeptName = sc.next();
            if (NewdeptName.equals("n")) {
                NewdeptName = deptName;
            }
            System.out.println("请输入要修改的部门所在地 输入n不修改");
            String deptAddress = sc.next();
            if (deptAddress.equals("n")) {
                deptAddress = loc;
            }
            Dept dept = new Dept(deptno, NewdeptName, deptAddress);
            int i = deptDaoimpl.updateDept(dept);
            if (i == 0) {
                System.out.println("修改失败");
            } else {
                System.out.println("修改成功");
            }

        }
    }

    /**
     * 添加部门信息
     */
    public static void insert() {
        DeptDaoimpl deptDaoimpl = new DeptDaoimpl();
        System.out.println("请输入部门id");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false) {
            System.out.println("输入的不是整数 重新输入");
            return;
        }
        int deptId = sc.nextInt();
        System.out.println("请输入部门名称");
        String deptName = sc.next();
        System.out.println("请输入部门所在地");
        String deptAddress = sc.next();
        Dept dept = new Dept(deptId, deptName, deptAddress);
        boolean exist = deptDaoimpl.isExistdeptno(deptId);
        if (exist == true) {
            System.out.println("deptno或者loc 已存在 不能重复添加");
            return;
        } else {
            deptDaoimpl.addDept(dept);
            System.out.println("添加成功");
        }
    }

    /**
     * 打印表头信息
     * @return 用户选择的操作编号
     */
    public static int printHeader() {
        System.out.println("欢迎登录员工管理系统");
        System.out.println("请选择你要操作的数据表");
        System.out.println("-------------------------");
        System.out.println("1,添加部门信息");
        System.out.println("2,修改部门信息");
        System.out.println("3,删除部门信息");
        System.out.println("4,查询所有部门信息");
        System.out.println("5,根据部门编号查询部门信息");
        System.out.println("6,退出系统");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        return i;
    }
}
        System.out.println("4,查询所有部门信息");
        System.out.println("5根据id查询部门信息");
        System.out.println("6,退出");
        System.out.println("请选择你要执行的功能");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false) {
            System.out.println("输入的不是整数 重新输入");
            return;
        }
        int choice = sc.nextInt();
        return choice;
    }
}
