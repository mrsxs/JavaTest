package com.song.dao.impl;

import com.song.dao.SalesDao;
import com.song.entity.Sales;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 销售记录数据访问层实现类
 * @Author song
 */

public class SalesDaoimpl extends BaseDao implements SalesDao {

    /**
     * 添加销售记录
     * 
     * @param sales 销售记录对象
     * @return 返回受影响的行数
     */
    @Override
    public int addSales(Sales sales) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 添加销售记录
            String sql = "insert into Sales(SellAmount,GoodId,EmployeeId,SellDate) values(?,?,?,?)";
            // 参数 销售数量 商品id 职员id 销售日期
            Object[] params = {sales.getSellAmount(), sales.getGoods().getGoodsId(), sales.getEmployee().getEmployeeId(), sales.getSellDate()};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        return count;
    }

    /**
     * 删除销售记录
     *
     * @param id 销售记录id
     * @return 返回受影响的行数
     */
    @Override
    public int deleteSales(int id) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 删除销售记录
            String sql = "delete from Sales where SalesId = ?";
            // 参数 销售记录id
            Object[] params = {id};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    /**
     * 修改销售记录
     *
     * @param sales
     * @return
     */
    @Override
    public int updateSales(Sales sales) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 修改销售记录
            String sql = "update Sales set SellAmount = COALESCE(?,SellAmount),GoodId = COALESCE(?,GoodId),EmployeeId = COALESCE(?,EmployeeId),SellDate =COALESCE(?,SellDate) where SalesId = ?";
           // 参数 销售数量 商品id 职员id 销售日期 销售记录id
            Object[] params = {sales.getSellAmount(), sales.getGoods().getGoodsId(), sales.getEmployee().getEmployeeId(), sales.getSellDate(), sales.getSalesId()};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        return count;
    }

    /**
     * 多条件查询
     * @param minSellAmount  最小销售数量
     * @param maxSellAmount 最大销售数量
     * @param goodName 商品名
     * @param empName 职员名
     * @param minSellDate 销售日期最早
     * @param maxSellDate 销售日期最晚
     * @return 返回销售记录集合
     */
    @Override
    public List<Sales> compoundQuery(int minSellAmount, int maxSellAmount, String goodName, String empName, String minSellDate, String maxSellDate) {
        List<Sales> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句 多条件查询
            String sql = "select * from Sales where 1=1";
            // 判断最小销售数量是否为0
            if (minSellAmount != 0) {
                sql += " and SellAmount >= " + minSellAmount;
            }
            // 判断最大销售数量是否为0
            if (maxSellAmount != 0) {
                sql += " and SellAmount <= " + maxSellAmount;
            }
            // 判断商品名是否为空
            if (goodName != null && !goodName.equals("")) {
                sql += " and GoodId in (select GoodId from Goods where GoodName like '%" + goodName + "%')";
            }
            // 判断职员名是否为空
            if (empName != null && !empName.equals("")) {
                sql += " and EmployeeId in (select EmployeeId from Employee where EmpName like '%" + empName + "%')";
            }
            // 判断最小销售日期是否为空
            if (minSellDate != null && !minSellDate.equals("")) {
                sql += " and SellDate >= '" + minSellDate + "'";
            }
            // 判断最大销售日期是否为空
            if (maxSellDate != null && !maxSellDate.equals("")) {
                sql += " and SellDate <= '" + maxSellDate + "'";
            }
            System.out.println(sql);
            rs = super.executeQuery(sql);
            next(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }

        return list;
    }

    /**
     * 遍历结果集
     *
     * @param list 销售记录集合
     * @throws SQLException sql异常
     */
    private void next(List<Sales> list) throws SQLException {
        while (rs.next()) {
            Sales sale = new Sales();
            sale.setSalesId(rs.getInt("SalesId"));
            sale.setSellAmount(rs.getInt("SellAmount"));
            sale.setSellDate(rs.getString("SellDate"));
            sale.setEmployee(new EmployeeDaoimpl().selectEmployeeById(rs.getInt("EmployeeId")));
            sale.setGoods(new GoodsDaoimpl().queryGoodsById(rs.getInt("GoodId")));
            list.add(sale);
        }
    }


    /**
     * 查询销售记录
     *
     * @return 返回销售记录集合
     */
    @Override
    public List<Sales> selectSales() {
        List<Sales> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句 查询销售记录
            String sql = "select * from Sales";
            rs = super.executeQuery(sql);
            next(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            super.connClose();
        }
        return list;
    }

    /**
     * 根据id查询销售记录
     *
     * @param id 销售记录id
     * @return 返回销售记录对象
     */
    @Override
    public boolean isExist(int id) {
        boolean flag = false;
        try {
            super.getConnection();
            // sql语句 判断销售记录是否存在
            String sql = "select * from Sales where SalesId = ?";
            Object[] params = {id};
            rs = super.executeQuery(sql, params);
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        return flag;
    }
}
