package com.song.dao;

import com.song.entity.Sales;

import java.util.List;

/**
 * 销售记录的数据库操作类
 * 
 * @author song
 */

public interface SalesDao {
    /**
     * 添加销售记录
     * 
     * @param sales 销售记录对象
     * @return 返回受影响的行数
     */
    public int addSales(Sales sales);

    /**
     * 删除销售记录
     *
     * @param id 销售记录id
     * @return 返回受影响的行数
     */
    public int deleteSales(int id);

    /**
     * 修改销售记录
     *
     * @param sales 销售记录对象
     * @return 返回受影响的行数
     */
    public int updateSales(Sales sales);

    /**
     * 多条件查询
     * 
     * @param minSellAmount 最小销售数量
     * @param maxSellAmount 最大销售数量
     * @param goodName      商品名称
     * @param empName       员工姓名
     * @param minSellDate   最小销售日期
     * @param maxSellDate   最大销售日期
     * @return 返回销售记录集合
     */
    public List<Sales> compoundQuery(int minSellAmount, int maxSellAmount, String goodName, String empName,
            String minSellDate, String maxSellDate);

    /**
     * 查询所有销售记录
     * 
     * @return 返回销售记录集合
     */
    public List<Sales> selectSales();

    /**
     * 判断id是否存在
     * 
     * @param id 销售记录id
     * @return 返回布尔值
     */
    public boolean isExist(int id);
}
