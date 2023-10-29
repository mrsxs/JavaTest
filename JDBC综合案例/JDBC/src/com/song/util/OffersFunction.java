package com.song.util;

import com.song.Test.ShopdbTest;
import com.song.dao.OffersDao;
import com.song.dao.impl.OffersDaoimpl;
import com.song.entity.Offers;

import java.util.List;
import java.util.Scanner;

public class OffersFunction {

    /**
     * 打印菜单
     */
    public static void OffersStart() {
        while (true) {
        System.out.println("***************供货商信息管理系统***************");
        System.out.println("1.添加供货商信息");
        System.out.println("2.删除供货商信息");
        System.out.println("3.修改供货商信息");
        System.out.println("4.查询供货商信息");
        System.out.println("5.退出系统");
        System.out.println("**********************************************");
        System.out.println("请输入你的选择：");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

            switch (i) {
                case 1:
                    //添加供货商方法
                    addOffers();
                    break;
                case 2:
                    //删除供货商信息
                    deleteOffers();
                    break;
                case 3:
                    //修改供货商信息
                    updateOffers();
                    break;
                case 4:
                    //多条件查询
                    queryoffers();
                    break;
                case 5:
                    //退出系统
                    System.out.println("退出成功");
                    //返回上一级菜单
                    ShopdbTest.printMenu();
                default:
                    System.out.println("输入的数字不在范围内 请重新输入");
            }
        }
    }

    /**
     * 多条件查询
     */
    private static void queryoffers() {
        String OfferName = null;
        String LegalIP = null;
        String Address = null;
        String Tel = null;
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("是否根据供货商名称进行多条件查询查询？y/n");
        String s = sc.next();
        if (s.equals("y")) {
            System.out.println("请输入要查询的供货商名称 可以模糊查询");
             OfferName = sc.next();
        }
        System.out.println("是否根据法人代表进行多条件查询？y/n");
        String s1 = sc.next();
        if (s1.equals("y")) {
            System.out.println("请输入要查询的法人代表");
             LegalIP = sc.next();
        }
        System.out.println("是否根据地址进行多条件查询？y/n");
        String s2 = sc.next();
        if (s2.equals("y")) {
            System.out.println("请输入要查询的地址");
            Address = sc.next();
        }
        System.out.println("是否根据电话进行多条件查询？y/n");
        String s3 = sc.next();
        if (s3.equals("y")) {
            System.out.println("请输入要查询的电话");
           Tel = sc.next();
        }
        Offers offers = new Offers(OfferName, LegalIP, Address, Tel);
        List<Offers> list = offersDaoimpl.queryOffers(offers);
        if (list.size() == 0) {
            System.out.println("没有查询到数据");
        } else {
            System.out.println("供货商编号\t供货商名称\t法人代表\t地址\t电话");
            for (Offers offers1 : list) {
                System.out.println(offers1.getOfferID() + "\t" + offers1.getOfferName() + "\t" + offers1.getLegalIP() + "\t" + offers1.getAddress() + "\t" + offers1.getTel());
            }
        }

    }

    private static void queryOffers() {
        System.out.println("请输入要查询的供货商名称 可以模糊查询");
    }

    /**
     * 修改供货商方法
     */

    private static void updateOffers() {
        queryAllOffers();
      OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        System.out.println("请输入要修改的供货商编号：");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false) {
            System.out.println("输入的供货商编号不合法");
            return;
        }
        int OfferID = sc.nextInt();
        boolean exist = offersDaoimpl.isExist(OfferID);
        if (exist == false) {
            System.out.println("输入的供货商编号不存在");
            return;
        }
        System.out.println("请输入要修改后的供货商名称：");
        String OfferName = sc.next();
        System.out.println("请输入要修改后的法人代表：");
        String LegalIP = sc.next();
        System.out.println("请输入要修改后的地址：");
        String Address = sc.next();
        System.out.println("请输入要修改后的电话：");
        String Tel = sc.next();
        Offers offers = new Offers(OfferID, OfferName, LegalIP, Address, Tel);
        int i = offersDaoimpl.updateOffers(offers);
        if (i == 0) {
            System.out.println("修改失败");
        } else {
            System.out.println("修改成功");
        }

    }

    /**
     * 查询所有供货商方法
     */
    private static void queryAllOffers() {
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        List<Offers> list = offersDaoimpl.queryAllOffers();
        for (Offers offers : list) {
            System.out.println(offers.getOfferID() + "\t"
                    + offers.getOfferName() + "\t" + offers.getLegalIP() +
                    "\t" + offers.getAddress() + "\t" + offers.getTel());
        }
    }

    /**
     * 删除供货商方法
     */
    private static void deleteOffers() {
        System.out.println("请输入要删除的供货商编号：");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false) {
            System.out.println("输入的供货商编号不合法");
            return;
        }
        int OfferID = sc.nextInt();
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        int i = offersDaoimpl.deleteOffers(OfferID);
        if (i == 0) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
    }

    /**
     * 添加供货商方法
     */
    private static void addOffers() {
        Scanner sc = new Scanner(System.in);
        queryAllOffers();
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        System.out.println("请输入供货商名称：");
        String OfferName = sc.next();
        System.out.println("请输入法人代表：");
        String LegalIP = sc.next();
        System.out.println("请输入地址：");
        String Address = sc.next();
        System.out.println("请输入电话：");
        String Tel = sc.next();
        //利用正则表达式判断电话号码是否合法
        String regex = "1[3|5|7|8|9]\\d{9}";
        if (Tel.matches(regex) == false) {
            System.out.println("输入的电话号码不合法");
            return;
        }
        Offers offers = new Offers(OfferName, LegalIP, Address, Tel);

        int i = offersDaoimpl.addOffers(offers);
        if (i == 0) {
            System.out.println("添加失败");
        } else {
            System.out.println("添加成功");
        }
    }

}
