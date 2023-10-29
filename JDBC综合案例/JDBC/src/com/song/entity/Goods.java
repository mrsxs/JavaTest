package com.song.entity;

public class Goods {
    private int goodsId;
    private String goodsName;
    private double price;
    private Category category;
    private Offers offers;
    private int stockes;

    public Goods() {
        // 默认构造函数
    }

    /**
     * 有参构造函数
     *
     * @param goodsId
     * @param goodsName
     * @param price
     * @param category
     * @param offers
     * @param stockes
     */

    public Goods(int goodsId, String goodsName, double price, Category category, Offers offers, int stockes) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.price = price;
        this.category = category;
        this.offers = offers;
        this.stockes = stockes;
    }


    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public int getStockes() {
        return stockes;
    }

    public void setStockes(int stockes) {
        this.stockes = stockes;
    }

}
