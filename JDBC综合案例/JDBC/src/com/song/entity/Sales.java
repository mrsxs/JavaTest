package com.song.entity;
/**
 * 销售实体类
 * @Author song
 */
public class Sales {
    
    /**
     * 销售id
     */
   
    private int salesId; 
    /**
     * 销售数量
     */
    private int sellAmount; 
    /**
     * 商品外键
     */
    private Goods goods = new Goods();
    /**
     * 员工外键
     */
    
    private Employee employee = new Employee(); 
    /**
     * 销售日期
     */
    private String sellDate; 

/**
 * 无参构造方法
 */
    public Sales() {
    }
    /**
     * 有参构造方法
     * @param salesId 销售id
     * @param sellAmount 销售数量
     * @param goods 商品外键
     * @param employee 员工外键
     * @param sellDate 销售日期
     */

    public Sales(int salesId, int sellAmount, Goods goods, Employee employee, String sellDate) {
        this.salesId = salesId;
        this.sellAmount = sellAmount;
        this.goods = goods;
        this.employee = employee;
        this.sellDate = sellDate;
    }

    /**
     * 获取
     *
     * @return salesId
     */
    public int getSalesId() {
        return salesId;
    }

    /**
     * 设置
     *
     * @param salesId
     */
    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    /**
     * 获取
     *
     * @return sellAmount
     */
    public int getSellAmount() {
        return sellAmount;
    }

    /**
     * 设置
     *
     * @param sellAmount
     */
    public void setSellAmount(int sellAmount) {
        this.sellAmount = sellAmount;
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
     * @return sellDate
     */
    public String getSellDate() {
        return sellDate;
    }

    /**
     * 设置
     *
     * @param SellDate
     */
    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public String toString() {
        return "Sales{SalesId = " + salesId + ", SellAmount = " + sellAmount + ", goods = " + goods + ", employee = " + employee + ", SellDate = " + sellDate + "}";
    }
}
