package com.song.util;

import com.song.Test.ShopdbTest;
import com.song.dao.impl.CategoryDaoimpl;
import com.song.dao.impl.GoodsDaoimpl;
import com.song.dao.impl.OffersDaoimpl;
import com.song.entity.Category;
import com.song.entity.Goods;
import com.song.entity.Offers;

import java.util.List;
import java.util.Scanner;

public class GoodsFunction {
    public static void main(String[] args) {
        GoodsStart();
    }

    /**
     * 商品管理
     */
    public static void GoodsStart() {
        while (true) {
            System.out.println("***************商品信息管理系统***************");
            System.out.println("1.添加商品信息");
            System.out.println("2.修改商品信息");
            System.out.println("3.删除商品信息");
            System.out.println("4.多条件查询商品信息");
            System.out.println("5.退出系统");
            System.out.println("**********************************************");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    //添加商品方法
                    addGoods();
                    break;
                case 2:
                    //修改商品信息
                    updateGoods();
                    break;
                case 3:
                    //删除商品信息
                  deleteGoods();
                    break;
                case 4:
                    //多条件查询
                    CompoundQuery();
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

    private static void CompoundQuery() {
        Scanner sc = new Scanner(System.in);
        String goodsName = null;
        double price = 0;
        int categoryId = 0;
        int offerId = 0;
        System.out.println("是否根据商品名称查询 y/n");
        String s = sc.next();

        if (s.equalsIgnoreCase("y")) {
            System.out.println("请输入商品名称");
            goodsName = sc.next();
        }
        System.out.println("是否根据商品价格查询 y/n");
        String s1 = sc.next();
        if (s1.equalsIgnoreCase("y")) {
            System.out.println("请输入商品价格");
            price = sc.nextDouble();
        }
        System.out.println("是否根据商品类别查询 y/n");
        String s2 = sc.next();
        if (s2.equalsIgnoreCase("y")) {
            System.out.println("请输入商品类别id");
            queryCategory();
            categoryId = sc.nextInt();
            //判断有没有这个id
            CategoryDaoimpl categoryDaoimpl = new CategoryDaoimpl();
            boolean isExist = categoryDaoimpl.isExist(categoryId);
            if (!isExist) {
                System.out.println("输入的类别id不存在");
                return;
            }
        }
        System.out.println("是否根据供货商查询 y/n");
        String s3 = sc.next();
        if (s3.equalsIgnoreCase("y")) {
            System.out.println("请输入供货商id");
            queryOffers();
            offerId = sc.nextInt();
            //判断有没有这个id
            OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
            boolean exist = offersDaoimpl.isExist(offerId);
            if (!exist) {
                System.out.println("输入的供货商id不存在");
                return;
            }
        }
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setPrice(price);
        goods.setCategory(new CategoryDaoimpl().queryCategoryById(categoryId));
        goods.setOffers(new OffersDaoimpl().queryOffersById(offerId));
        GoodsDaoimpl goodsDaoimpl = new GoodsDaoimpl();
        List<Goods> list = goodsDaoimpl.CompoundQuery(goods);
        System.out.println("商品编号\t商品名称\t商品价格\t商品类别\t供货商\t商品库存");
        for (Goods good : list) {
            System.out.println(good.getGoodsId() + "\t" + good.getGoodsName() + "\t" + good.getPrice() + "\t" + good.getCategory().getCategoryName() + "\t" + good.getOffers().getOfferName() + "\t" + good.getStockes());
        }
    }

    /**
     * 删除商品信息
     */

    private static void deleteGoods() {
        Scanner sc = new Scanner(System.in);
        queryGoods();
        System.out.println("请输入要删除的商品id");
        int GoodsId = sc.nextInt();
        GoodsDaoimpl goodsDaoimpl = new GoodsDaoimpl();
        boolean exist = goodsDaoimpl.isExist(GoodsId);
        if (!exist) {
            System.out.println("输入的商品id不存在");
            return;
        }
        int count = goodsDaoimpl.deleteGoods(GoodsId);
        if (count > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 修改商品信息
     */
    private static void updateGoods() {
        String goodsName = null;
        double price = 0;
        int categoryId = 0;
        int offerId = 0;
        int stockes = 0;
        CategoryDaoimpl categoryDaoimpl = new CategoryDaoimpl();
        queryGoods();
        System.out.println("请输入要修改的商品id");
        Scanner sc = new Scanner(System.in);
        int goodsId = sc.nextInt();
        GoodsDaoimpl goodsDaoimpl = new GoodsDaoimpl();
        boolean exist = goodsDaoimpl.isExist(goodsId);
        if (!exist) {
            System.out.println("输入的商品id不存在");
            return;
        }
        System.out.println("是否修改商品名称 y/n");
        String s = sc.next();
        if (s.equalsIgnoreCase("y")) {
            System.out.println("请输入新的商品名称");
            goodsName = sc.next();
        }
        System.out.println("是否修改商品价格 y/n");
        String s1 = sc.next();
        if (s1.equalsIgnoreCase("y")) {
            System.out.println("请输入新的商品价格");
            price = sc.nextDouble();
        }
        System.out.println("是否修改商品类别 y/n");
        String s2 = sc.next();
        if (s2.equalsIgnoreCase("y")) {


            System.out.println("请输入新的商品类别id");
            queryCategory();
            categoryId = sc.nextInt();
            //判断有没有这个id

            boolean isExist = categoryDaoimpl.isExist(categoryId);
            if (!isExist) {
                System.out.println("输入的类别id不存在");
                return;
            }
        }
            System.out.println("是否修改供货商 y/n");
            String s3 = sc.next();
            if (s3.equalsIgnoreCase("y")) {
                System.out.println("请输入新的供货商id");
                queryOffers();
                offerId = sc.nextInt();
                //判断有没有这个id
                boolean exist1 = goodsDaoimpl.isExist(offerId);
                if (!exist1) {
                    System.out.println("输入的供货商id不存在");
                    return;
                }
            }
                System.out.println("是否修改商品库存 y/n");
                String s4 = sc.next();
                if (s4.equalsIgnoreCase("y")) {
                    System.out.println("请输入新的商品库存");
                    stockes = sc.nextInt();
                }
                Goods goods = new Goods();
                goods.setGoodsId(goodsId);
                goods.setGoodsName(goodsName);
                goods.setPrice(price);
                goods.setCategory(categoryDaoimpl.queryCategoryById(categoryId));
                goods.setOffers(new OffersDaoimpl().queryOffersById(offerId));
                goods.setStockes(stockes);
                int count = goodsDaoimpl.updateGoods(goods);
                if (count > 0) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }


    }


    /**
     * 添加商品
     */
    private static void addGoods() {
        queryGoods();
        GoodsDaoimpl goodsDaoimpl = new GoodsDaoimpl();
        System.out.println("请输入商品名称");
        Scanner sc = new Scanner(System.in);
        String goodsName = sc.next();
        System.out.println("请输入商品价格");
        double price = sc.nextDouble();
        System.out.println("请输入商品所属类别id");
        CategoryDaoimpl categoryDaoimpl = new CategoryDaoimpl();
        queryCategory();

        int categoryId = sc.nextInt();
        //判断有没有这个id
        boolean isExist = categoryDaoimpl.isExist(categoryId);
        if (!isExist) {
            System.out.println("输入的类别id不存在");
            return;
        }
        System.out.println("请输入所属供货商id");
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        queryOffers();
        int offerId = sc.nextInt();
        //判断有没有这个id
        boolean isExist1 = offersDaoimpl.isExist(offerId);
        if (!isExist1) {
            System.out.println("输入的供货商id不存在");
            return;
        }
        System.out.println("请输入商品库存");
        int stockes = sc.nextInt();
        Goods goods1 = new Goods();
        goods1.setGoodsName(goodsName);
        goods1.setPrice(price);
        goods1.setCategory(categoryDaoimpl.queryCategoryById(categoryId));
        goods1.setOffers(offersDaoimpl.queryOffersById(offerId));
        goods1.setStockes(stockes);
        int count = goodsDaoimpl.addGoods(goods1);
        if (count > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }


    /**
     * 查询所有类别
     */
    private static void queryCategory() {
        CategoryDaoimpl categoryDaoimpl = new CategoryDaoimpl();
        List<Category> list = categoryDaoimpl.queryCategory();
        System.out.println("类别编号\t类别名称");
        for (Category category : list) {
            System.out.println(category.getCategoryId() + "\t" + category.getCategoryName());
        }
    }


    /**
     * 查询所有商品
     */
    private static void queryGoods() {
        GoodsDaoimpl goodsDaoimpl = new GoodsDaoimpl();
        List<Goods> goods = goodsDaoimpl.selectGoods();
        //打印商品信息
        System.out.println("商品编号\t商品名称\t商品价格\t商品类别\t供货商\t商品库存");
        for (Goods good : goods) {
            System.out.println(good.getGoodsId() + "\t" + good.getGoodsName() + "\t" + good.getPrice() + "\t" + good.getCategory().getCategoryName() + "\t" + good.getOffers().getOfferName() + "\t" + good.getStockes());
        }

    }

    /**
     * 查询所有供货商
     */
    private static void queryOffers() {
        OffersDaoimpl offersDaoimpl = new OffersDaoimpl();
        List<Offers> offers = offersDaoimpl.queryAllOffers();
        System.out.println("供货商编号\t供货商名称\t供货商地址\t供货商电话");
        for (Offers offer : offers) {
            System.out.println(offer.getOfferID() + "\t" + offer.getOfferName() + "\t" + offer.getAddress() + "\t" + offer.getTel());
        }
    }
}