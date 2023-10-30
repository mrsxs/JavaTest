package com.song.util;

import com.song.Test.ShopdbTest;
import com.song.dao.impl.EmployeeDaoimpl;
import com.song.dao.impl.GoodsDaoimpl;
import com.song.dao.impl.SalesDaoimpl;
import com.song.entity.Employee;
import com.song.entity.Goods;
import com.song.entity.Sales;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.song.util.GoodsFunction.queryGoods;

public class SalesFunction {
    public static void main(String[] args) {
        SalesStart();
    }


    /**
     * 打印菜单
     */
    public static void SalesStart() {
        while (true) {
            System.out.println("欢迎使用销售信息表");
            System.out.println("请选择你要进行的操作：1添加 2删除 3修改 4多条件查询 5退出");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    //添加
                    addSales();
                    break;
                case 2:
                    //删除
                    deleteSales();
                    break;
                case 3:
                    //修改
                    updateSales();
                    break;
                case 4:
                    //查询
                    CompoundQuery();
                    break;
                case 5:
                    //退出返回主菜单
                    System.out.println("退出成功");
                    ShopdbTest.printMenu();
                default:
                    System.out.println("输入的数字不在范围内 请重新输入");
            }
        }
    }

    /**
     * 删除销售记录
     */
    private static void deleteSales() {
        Scanner sc = new Scanner(System.in);
        SalesDaoimpl salesDaoimpl = getSalesDaoimpl();
        System.out.println("请输入要删除的销售id");
        int id = sc.nextInt();
        boolean exist = salesDaoimpl.isExist(id);
        if (exist == false) {
            System.out.println("输入的id不存在");
            return;
        }
        int i = salesDaoimpl.deleteSales(id);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 多条件查询
     */
    private static void CompoundQuery() {
        Scanner sc = new Scanner(System.in);
        System.out.println("是否根据数量区间查询 y/n");
        String s = sc.next();
        int min = 0;
        int max = 0;
        if (s.equalsIgnoreCase("y")) {
            System.out.println("请输入最小数量");
            min = sc.nextInt();
            System.out.println("请输入最大数量");
            max = sc.nextInt();
        }
        System.out.println("是否根据商品名字查询 y/n");
        String s1 = sc.next();
        String name = null;
        if (s1.equalsIgnoreCase("y")) {
            System.out.println("请输入商品名字");
            name = sc.next();
        }
        System.out.println("是否根据职员名字查询 y/n");
        String s2 = sc.next();
        String name1 = null;
        if (s2.equalsIgnoreCase("y")) {
            System.out.println("请输入职员名字");
            name1 = sc.next();
        }
        System.out.println("是否根据销售日期区间查询 y/n");
        String s3 = sc.next();
        String date = null;
        String date1 = null;
        if (s3.equalsIgnoreCase("y")) {
            System.out.println("请输入最小日期");
            date = sc.next();
            System.out.println("请输入最大日期");
            date1 = sc.next();
        }
        SalesDaoimpl salesDaoimpl = new SalesDaoimpl();
        List<Sales> sales = salesDaoimpl.CompoundQuery(min, max, name, name1, date, date1);
        System.out.println("销售id\t销售数量\t商品名称\t职员名称\t销售日期");
        for (Sales sale : sales) {
            System.out.println(sale.getSalesId() + "\t" + sale.getSellAmount() + "\t" + sale.getGoods().getGoodsName() + "\t" + sale.getEmployee().getEmpName() + "\t" + sale.getSellDate());
        }
    }

    /**
     * 修改销售记录
     */
    private static void updateSales() {
        int goodsId = 0;
        Scanner sc = new Scanner(System.in);
        SalesDaoimpl salesDaoimpl = getSalesDaoimpl();
        System.out.println("请输入要修改的销售id");
        int id = sc.nextInt();
        boolean exist = salesDaoimpl.isExist(id);
        if (exist == false) {
            System.out.println("输入的id不存在");
            return;
        }
        System.out.println("是否修改商品名字 y/n");
        String s = sc.next();
        if (s.equalsIgnoreCase("y")) {
            System.out.println("请选择要修改的商品id");
            queryGoods();
            goodsId = sc.nextInt();
        }
        System.out.println("是否修改销售数量 y/n");
        String s1 = sc.next();
        int number = 0;
        if (s1.equalsIgnoreCase("y")) {
            System.out.println("请输入要修改的销售数量");
            number = sc.nextInt();
        }
        System.out.println("是否修改职员信息 y/n");
        String s2 = sc.next();
        int EmployeeId = 0;
        if (s2.equalsIgnoreCase("y")) {
            System.out.println("请选择要修改的职员id");
            extracted();
            EmployeeId = sc.nextInt();
        }
        SalesDaoimpl salesDaoimpl1 = new SalesDaoimpl();
        Sales sales1 = new Sales();
        Goods goods = new GoodsDaoimpl().queryGoodsById(goodsId);
        Employee employee = new EmployeeDaoimpl().selectEmployeeById(EmployeeId);
        sales1.setSalesId(id);
        sales1.setGoods(goods);
        sales1.setEmployee(employee);
        sales1.setSellAmount(number);
        int i = salesDaoimpl1.updateSales(sales1);
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }


    }

    private static SalesDaoimpl getSalesDaoimpl() {
        SalesDaoimpl salesDaoimpl = new SalesDaoimpl();
        List<Sales> sales = salesDaoimpl.selectSales();
        System.out.println("销售id\t销售数量\t商品id\t职员id\t销售日期");
        for (Sales sale : sales) {
            System.out.println(sale.getSalesId() + "\t" + sale.getSellAmount() + "\t" + sale.getGoods().getGoodsName() + "\t" + sale.getEmployee().getEmpName() + "\t" + sale.getSellDate());
        }
        return salesDaoimpl;
    }


    /**
     * 添加销售记录
     */

    private static void addSales() {
        Scanner sc = new Scanner(System.in);


        System.out.println("请选择销售的商品id");
        //查询商品
        queryGoods();
        int goodsId = sc.nextInt();
        System.out.println("请输入销售的数量");
        int number = sc.nextInt();
        System.out.println("请选择售卖商品的职员id");
        extracted();
        int EmployeeId = sc.nextInt();
        //获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间
        Goods goods = new GoodsDaoimpl().queryGoodsById(goodsId);
        Employee employee = new EmployeeDaoimpl().selectEmployeeById(EmployeeId);
        SalesDaoimpl salesDaoimpl = new SalesDaoimpl();
        Sales sales = new Sales();
        sales.setSellAmount(number);
        sales.setSellDate(date);
        sales.setEmployee(employee);
        sales.setGoods(goods);
        int i = salesDaoimpl.addSales(sales);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

    }

    /**
     * 查询所有职员信息
     */

    private static void extracted() {
        EmployeeDaoimpl employeeDaoimpl = new EmployeeDaoimpl();
        List<Employee> employees = employeeDaoimpl.selectEmployee();
        System.out.println("职员id\t职员姓名\t职员性别\t职员年龄\t职员薪资");
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeId() + "\t" + employee.getEmpName() + "\t" + employee.getSex() + "\t" + employee.getAge() + "\t" + employee.getSalary());
        }
    }
}
