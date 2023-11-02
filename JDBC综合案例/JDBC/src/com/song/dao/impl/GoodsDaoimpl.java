package com.song.dao.impl;

import com.song.dao.GoodsDao;
import com.song.entity.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品数据访问层实现类
 * @author song
 */
public class GoodsDaoimpl extends BaseDao implements GoodsDao {


    /**
     * 添加商品
     *
     * @param goods 商品对象
     * @return 返回受影响的行数
     */
    @Override
    public int addGoods(Goods goods) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 添加商品
            String sql = "insert into Goods(GoodName,Price,CategoryId,OfferID,Stockes) values(?,?,?,?,?)";
            // 参数 商品名 价格 分类id 供货商id 库存 数量 
            Object[] params = {goods.getGoodsName(), goods.getPrice(), goods.getCategory().getCategoryId(), goods.getOffers().getOfferId(), goods.getStockes()};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    /**
     * 删除商品
     *
     * @param id  商品id
     * @return 返回受影响的行数
     */
    @Override
    public int deleteGoods(int id) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 删除商品
            String sql = "delete from Goods where GoodId = ?";
            // 参数 商品id
            count = super.executeUpdate(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return count;
    }


    /**
     * 修改商品
     *
     * @param goods 商品对象
     * @return 返回受影响的行数
     */
    @Override
    public int updateGoods(Goods goods) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 修改商品
            String sql = "update Goods set GoodName = COALESCE(?,GoodName)";
            List<Object> params = new ArrayList<>();
            params.add(goods.getGoodsName());
            // 判断价格是否为空
            if (goods.getPrice() != 0 && goods.getPrice() != 0) {
                sql += ", Price = ?";
                params.add(goods.getPrice());
            }
            // 判断分类是否为空
            if (goods.getCategory() != null && goods.getCategory().getCategoryId() != 0) {
                sql += ", CategoryId = ?";
                params.add(goods.getCategory().getCategoryId());
            }
            // 判断供货商是否为空
            if (goods.getOffers() != null && goods.getOffers().getOfferId() != 0) {
                sql += ", OfferID = ?";
                params.add(goods.getOffers().getOfferId());
            }
            // 判断库存是否为空
            if (goods.getStockes() != 0) {
                sql += ", Stockes = ?";
                params.add(goods.getStockes());
            }
            // 拼接sql语句
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
     * @return 返回商品集合
     */
    @Override
    public List<Goods> selectGoods() {
        List<Goods> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句 查询商品
            String sql = "select * from Goods";
            next(list, sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            super.connClose();
        }
        return list;
    }

    /**
     * 多条件查询商品
     *
     * @param goods 商品对象
     * @return 返回商品集合
     */
    @Override
    public List<Goods> compoundQuery(Goods goods) {
        List<Goods> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句 多条件查询商品
            String sql = "select * from Goods where 1=1";
            // 判断商品名是否为空
            if (goods.getGoodsName() != null && !goods.getGoodsName().equals("")) {
                sql += " and GoodName like '%" + goods.getGoodsName() + "%'";
            }
            // 判断价格是否为空
            if (goods.getPrice() != 0) {
                sql += " and Price = " + goods.getPrice();
            }
            // 判断库存是否为空
            if (goods.getCategory() != null && goods.getCategory().getCategoryId() != 0) {
                sql += " and CategoryId = " + goods.getCategory().getCategoryId();
            }
            // 判断供货商是否为空
            if (goods.getOffers() != null && goods.getOffers().getOfferId() != 0) {
                sql += " and OfferID = " + goods.getOffers().getOfferId();
            }
            next(list, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            super.connClose();
        }
        return list;
    }

    /**
     * 判断商品是否存在
     *
     * @param id 商品id
     * @return 返回布尔值
     */
    @Override
    public boolean isExist(int id) {
        boolean flag = false;
        try {
            super.getConnection();
            // sql语句 判断商品是否存在
            String sql = "select * from Goods where GoodId = ?";
            Object[] params = {id};
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            super.connClose();
        }
        return flag;
    }


    /**
     * 根据id查询商品
     *
     * @param id 商品id
     * @return 返回商品对象
     */
    @Override
    public Goods queryGoodsById(int id) {
        Goods goods = new Goods();
        try {
            super.getConnection();
            // sql语句 根据id查询商品
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
        }finally {
            super.connClose();
        }
        return goods;
    }

    /**
     * 封装查询结果
     *
     * @param list 商品集合
     * @param sql sql语句
     * @throws SQLException 抛出异常
     */
    private void next(List<Goods> list, String sql) throws SQLException {
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
