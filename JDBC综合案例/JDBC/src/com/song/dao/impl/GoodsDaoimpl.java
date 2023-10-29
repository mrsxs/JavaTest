package com.song.dao.impl;

import com.song.dao.GoodsDao;
import com.song.entity.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品数据访问层实现类
 */
public class GoodsDaoimpl extends BaseDao implements GoodsDao {


    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    @Override
    public int addGoods(Goods goods) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "insert into Goods(GoodName,Price,CategoryId,OfferID,Stockes) values(?,?,?,?,?)";
            Object prams[] = {goods.getGoodsName(), goods.getPrice(), goods.getCategory().getCategoryId(), goods.getOffers().getOfferID(), goods.getStockes()};
            count = super.executeUpdate(sql, prams);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @Override
    public int deleteGoods(int id) {
        int count = 0;

        try {
            super.getConnection();
            String sql = "delete from Goods where GoodId = ?";
            Object prams[] = {id};
            count = super.executeUpdate(sql, prams);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return count;
    }


    /**
     * 修改商品
     *
     * @param goods
     * @return
     */
    @Override
    public int updateGoods(Goods goods) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "update Goods set GoodName = COALESCE(?,GoodName)";
            List<Object> params = new ArrayList<>();
            params.add(goods.getGoodsName());
            if (goods.getPrice() != 0 && goods.getPrice() != 0) {
                sql += ", Price = ?";
                params.add(goods.getPrice());
            }
            if (goods.getCategory() != null && goods.getCategory().getCategoryId() != 0) {
                sql += ", CategoryId = ?";
                params.add(goods.getCategory().getCategoryId());
            }
            if (goods.getOffers() != null && goods.getOffers().getOfferID() != 0) {
                sql += ", OfferID = ?";
                params.add(goods.getOffers().getOfferID());
            }
            if (goods.getStockes() != 0) {
                sql += ", Stockes = ?";
                params.add(goods.getStockes());
            }
            sql += " where GoodId = ?";
            params.add(goods.getGoodsId());
            Object[] prams = params.toArray();
            count = super.executeUpdate(sql, prams);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    /**
     * 查询商品
     *
     * @return
     */
    @Override
    public List<Goods> selectGoods() {
        List list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Goods";
            next(list, sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 多条件查询商品
     *
     * @param goods
     * @return
     */
    @Override
    public List<Goods> CompoundQuery(Goods goods) {
        List list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Goods where 1=1";
            if (goods.getGoodsName() != null && !goods.getGoodsName().equals("")) {
                sql += " and GoodName like '%" + goods.getGoodsName() + "%'";
            }
            if (goods.getPrice() != 0) {
                sql += " and Price = " + goods.getPrice();
            }
            if (goods.getCategory() != null && goods.getCategory().getCategoryId() != 0) {
                sql += " and CategoryId = " + goods.getCategory().getCategoryId();
            }
            if (goods.getOffers() != null && goods.getOffers().getOfferID() != 0) {
                sql += " and OfferID = " + goods.getOffers().getOfferID();
            }
            next(list, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 判断商品是否存在
     *
     * @param id
     * @return
     */
    @Override
    public boolean isExist(int id) {
        boolean flag = false;
        try {
            super.getConnection();
            String sql = "select * from Goods where GoodId = ?";
            Object[] params = {id};
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }


    /**
     * 根据id查询商品
     *
     * @param id
     * @return
     */
    @Override
    public Goods queryGoodsById(int id) {
        Goods goods = new Goods();
        try {
            super.getConnection();
            String sql = "select * from Goods where GoodId = ?";
            Object[] params = {id};
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                goods.setGoodsId(resultSet.getInt("GoodId"));
                goods.setGoodsName(resultSet.getString("GoodName"));
                goods.setPrice(resultSet.getDouble("Price"));
                goods.setStockes(resultSet.getInt("Stockes"));
                goods.setCategory(new CategoryDaoimpl().queryCategoryById(resultSet.getInt("CategoryId")));
                goods.setOffers(new OffersDaoimpl().queryOffersById(resultSet.getInt("OfferID")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }

    /**
     * 封装查询结果
     *
     * @param list
     * @param sql
     * @throws SQLException
     */
    private void next(List list, String sql) throws SQLException {
        ResultSet resultSet = super.executeQuery(sql);
        while (resultSet.next()) {
            Goods goods1 = new Goods();
            goods1.setGoodsId(resultSet.getInt("GoodId"));
            goods1.setGoodsName(resultSet.getString("GoodName"));
            goods1.setPrice(resultSet.getDouble("Price"));
            goods1.setStockes(resultSet.getInt("Stockes"));
            goods1.setCategory(new CategoryDaoimpl().queryCategoryById(resultSet.getInt("CategoryId")));
            goods1.setOffers(new OffersDaoimpl().queryOffersById(resultSet.getInt("OfferID")));
            list.add(goods1);
        }
    }
}
