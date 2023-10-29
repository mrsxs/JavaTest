package com.song.dao;

import com.song.entity.Sales;

import java.util.List;

public interface SalesDao {
    /**
     * 添加销售记录
     *
     * @param sales
     * @return
     */
    public int addSales(Sales sales);

    /**
     * 删除销售记录
     *
     * @param id
     * @return
     */
    public int deleteSales(int id);

    /**
     * 修改销售记录
     *
     * @param sales
     * @return
     */
    public int updateSales(Sales sales);

    /**
     * 多条件查询
     *
     * @return
     */
    public List<Sales> CompoundQuery(int minSellAmount, int maxSellAmount, String GoodName, String EmpName, String minSellDate, String maxSellDate);

    /**
     * 查询所有
     */
    public List<Sales> selectSales();

    /**
     * 判断id是否存在
     */
    public boolean isExist(int id);
}
