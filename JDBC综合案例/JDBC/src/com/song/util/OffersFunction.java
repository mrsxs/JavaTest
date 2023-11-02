package com.song.util;

import com.song.dao.impl.OffersDaoimpl;
import com.song.entity.Offers;
import com.song.test.ShopdbTest;

import java.util.List;
import java.util.Scanner;

/**
 * 供货商的功能类
 * 
 * @Author song
 */

public class OffersFunction {

    /**
     * 打印菜单
     */
    public static void offersStart() {
        while (true) {
            System.out.println("***************供货商信息管理系统***************");
            System.out.println("1.添加供货商信息");
            System.out.println("2.删除供货商信息");
            System.out.println("3.修改供货商信息");
            System.out.println("4.多条件查询供货商信息");
            System.out.println("5.退出系统");
            System.out.println("**********************************************");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();

            switch (i) {
                case 1:
                    // 添加供货商方法
                    addOffers();
                    break;
                case 2:
                    // 删除供货商信息
                    deleteOffers();
                    break;
                case 3:
                    // 修改供货商信息
                    updateOffers();
                    break;
                case 4:
                    // 多条件查询
                    queryoffers();
                    break;
                case 5:
                    // 退出系统
                    System.out.println("退出成功");
                    // 返回上一级菜单
                    ShopdbTest.printMenu();
                    break;
                default:
                    System.out.println("输入的数字不在范围内 请重新输入");
            }
            sc.close();
        }
    }

    /**
     * 多条件查询
     */
    private static void queryoffers() {
        String offerName = null;
        String legalIp = null;
        String address = null;
        String tel = null;
        final String yesOption = "y";
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("是否根据供货商名称进行多条件查询查询？y/n");
        String s = sc.next();
        if (s.equals(yesOption)) {
            System.out.println("请输入要查询的供货商名称 可以模糊查询");
            offerName = sc.next();
        }
        System.out.println("是否根据法人代表进行多条件查询？y/n");
        String s1 = sc.next();
        if (s1.equals(yesOption)) {
            System.out.println("请输入要查询的法人代表");
            legalIp = sc.next();
        }
        System.out.println("是否根据地址进行多条件查询？y/n");
        String s2 = sc.next();
        if (s2.equals(yesOption)) {
            System.out.println("请输入要查询的地址");
            address = sc.next();
        }
        System.out.println("是否根据电话进行多条件查询？y/n");
        String s3 = sc.next();
        if (s3.equals(yesOption)) {
            System.out.println("请输入要查询的电话");
            tel = sc.next();
        }
        Offers offers = new Offers(offerName, legalIp, address, tel);
        List<Offers> list = offersDaoimpl.queryOffers(offers);
        if (list.size() == 0) {
            System.out.println("没有查询到数据");
        } else {
            System.out.println("供货商编号\t供货商名称\t法人代表\t地址\t电话");
            for (Offers offers1 : list) {
                System.out.println(offers1.getOfferId() + "\t" + offers1.getOfferName() + "\t" + offers1.getLegalIp()
                        + "\t" + offers1.getAddress() + "\t" + offers1.getTel());
            }
        }
        sc.close();

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
            sc.close();
            return;
        }
        int offerId = sc.nextInt();
        boolean exist = offersDaoimpl.isExist(offerId);
        if (exist == false) {
            System.out.println("输入的供货商编号不存在");
            sc.close();
            return;
        }
        System.out.println("请输入要修改后的供货商名称：");
        String offerName = sc.next();
        System.out.println("请输入要修改后的法人代表：");
        String legalIp = sc.next();
        System.out.println("请输入要修改后的地址：");
        String address = sc.next();
        System.out.println("请输入要修改后的电话：");
        String tel = sc.next();
        Offers offers = new Offers(offerId, offerName, legalIp, address, tel);
        int i = offersDaoimpl.updateOffers(offers);
        if (i == 0) {
            System.out.println("修改失败");
        } else {
            System.out.println("修改成功");
        }
        sc.close();
    }

    /**
     * 查询所有供货商方法
     */
    private static void queryAllOffers() {
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        List<Offers> list = offersDaoimpl.queryAllOffers();
        for (Offers offers : list) {
            System.out.println(offers.getOfferId() + "\t"
                    + offers.getOfferName() + "\t" + offers.getLegalIp() +
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
            sc.close();
            return;
        }
        int offerId = sc.nextInt();
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        int i = offersDaoimpl.deleteOffers(offerId);
        if (i == 0) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
        sc.close();
    }

    /**
     * 添加供货商方法
     */
    private static void addOffers() {
        Scanner sc = new Scanner(System.in);
        queryAllOffers();
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        System.out.println("请输入供货商名称：");
        String offerName = sc.next();
        System.out.println("请输入法人代表：");
        String legalIp = sc.next();
        System.out.println("请输入地址：");
        String address = sc.next();
        System.out.println("请输入电话：");
        String tel = sc.next();
        // 利用正则表达式判断电话号码是否合法
        String regex = "1[3|5|7|8|9]\\d{9}";
        if (tel.matches(regex) == false) {
            System.out.println("输入的电话号码不合法");
            sc.close();
            return;
        }
        Offers offers = new Offers(offerName, legalIp, address, tel);

        int i = offersDaoimpl.addOffers(offers);
        if (i == 0) {
            System.out.println("添加失败");
        } else {
            System.out.println("添加成功");
        }
        sc.close();
    }


}
