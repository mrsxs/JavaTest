package com.song.dao.impl;

import com.song.dao.SalesDao;
import com.song.entity.Sales;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDaoimpl extends BaseDao implements SalesDao {

    /**
     * 添加销售记录
     *
     * @param sales
     * @return
     */
    @Override
    public int addSales(Sales sales) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "insert into Sales(SellAmount,GoodId,EmployeeId,SellDate) values(?,?,?,?)";
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
     * @param id
     * @return
     */
    @Override
    public int deleteSales(int id) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "delete from Sales where SalesId = ?";
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
            String sql = "update Sales set SellAmount = COALESCE(?,SellAmount),GoodId = COALESCE(?,GoodId),EmployeeId = COALESCE(?,EmployeeId),SellDate =COALESCE(?,SellDate) where SalesId = ?";
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
     * 多条件查询销售记录
     *
     * @param sales
     * @return
     */
    @Override
    public List<Sales> CompoundQuery(int minSellAmount, int maxSellAmount, String GoodName, String EmpName, String minSellDate, String maxSellDate) {
        List<Sales> list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Sales where 1=1";
            if (minSellAmount != 0) {
                sql += " and SellAmount >= " + minSellAmount;
            }
            if (maxSellAmount != 0) {
                sql += " and SellAmount <= " + maxSellAmount;
            }
            if (GoodName != null && !GoodName.equals("")) {
                sql += " and GoodId in (select GoodId from Goods where GoodName like '%" + GoodName + "%')";
            }
            if (EmpName != null && !EmpName.equals("")) {
                sql += " and EmployeeId in (select EmployeeId from Employee where EmpName like '%" + EmpName + "%')";
            }
            if (minSellDate != null && !minSellDate.equals("")) {
                sql += " and SellDate >= '" + minSellDate + "'";
            }
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
     * @param list
     * @throws SQLException
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
     * @return
     */
    @Override
    public List<Sales> selectSales() {
        List<Sales> list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Sales";
            rs = super.executeQuery(sql);
            next(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 根据id查询销售记录
     *
     * @param id
     * @return
     */
    @Override
    public boolean isExist(int id) {
        boolean flag = false;
        try {
            super.getConnection();
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
