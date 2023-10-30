package com.song.entity;

public class Sales {
    private int SalesId;
    private int SellAmount;
    private Goods goods = new Goods();
    private Employee employee = new Employee();
    private String SellDate;

    public Sales() {
    }

    public Sales(int SalesId, int SellAmount, Goods goods, Employee employee, String SellDate) {
        this.SalesId = SalesId;
        this.SellAmount = SellAmount;
        this.goods = goods;
        this.employee = employee;
        this.SellDate = SellDate;
    }

    /**
     * 获取
     *
     * @return SalesId
     */
    public int getSalesId() {
        return SalesId;
    }

    /**
     * 设置
     *
     * @param SalesId
     */
    public void setSalesId(int SalesId) {
        this.SalesId = SalesId;
    }

    /**
     * 获取
     *
     * @return SellAmount
     */
    public int getSellAmount() {
        return SellAmount;
    }

    /**
     * 设置
     *
     * @param SellAmount
     */
    public void setSellAmount(int SellAmount) {
        this.SellAmount = SellAmount;
    }

    /**
     * 获取
     *
     * @return goods
     */
    public Goods getGoods() {
        return goods;
    }

    /**
     * 设置
     *
     * @param goods
     */
    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    /**
     * 获取
     *
     * @return employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * 设置
     *
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * 获取
     *
     * @return SellDate
     */
    public String getSellDate() {
        return SellDate;
    }

    /**
     * 设置
     *
     * @param SellDate
     */
    public void setSellDate(String SellDate) {
        this.SellDate = SellDate;
    }

    public String toString() {
        return "Sales{SalesId = " + SalesId + ", SellAmount = " + SellAmount + ", goods = " + goods + ", employee = " + employee + ", SellDate = " + SellDate + "}";
    }
}
