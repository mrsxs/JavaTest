package com.song.dao.impl;

import com.song.dao.OffersDao;
import com.song.entity.Offers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 供货商数据访问层实现类
 * @author song
 */

public class OffersDaoimpl extends BaseDao implements OffersDao {

    /**
     * 添加供货商
     *
     * @param offers 供货商对象
     * @return 返回受影响的行数
     */
    @Override
    public int addOffers(Offers offers) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 添加供货商
            String sql = "insert into Offers(OfferName,LegalIP,Address,Tel) values(?,?,?,?)";
            // 参数 供货商名 法人  地址 电话
            Object[] params = {offers.getOfferName(), offers.getLegalIp(), offers.getAddress(), offers.getTel()};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    /**
     * 删除供货商
     *
     * @param OfferID 供货商id
     * @return 返回受影响的行数
     */

    @Override
    public int deleteOffers(int offerId) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 删除供货商
            String sql = "delete from Offers where OfferID = ?";
            Object[] params = {offerId};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    /**
     * 修改供货商
     *
     * @param offers 供货商对象
     * @return 返回受影响的行数
     */
    @Override
    public int updateOffers(Offers offers) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 修改供货商
            String sql = "update Offers set OfferName = ?,LegalIP = ?,Address = ?,Tel = ? where OfferID = ?";
            // 参数 供货商名 法人  地址 电话 供货商id
            Object[] params = {offers.getOfferName(), offers.getLegalIp(), offers.getAddress(), offers.getTel(), offers.getOfferId()};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    /**
     * 多条件查询
     *@param offers 供货商对象
     * @return 返回供货商集合
     */

    @Override
    public List<Offers> queryOffers(Offers offers) {
        List<Offers> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句 多条件查询
            String sql = "select * from Offers where 1=1";
            // 判断供货商id是否为空
            if (offers.getOfferId() != 0) {
                sql += " and OfferID = " + offers.getOfferId();
            }
            // 判断供货商名是否为空
            if (offers.getOfferName() != null && !"".equals(offers.getOfferName())) {
                sql += " and OfferName like '%" + offers.getOfferName() + "%'";
            }
            // 判断法人是否为空
            if (offers.getLegalIp() != null && !"".equals(offers.getLegalIp())) {
                sql += " and LegalIP like '%" + offers.getLegalIp() + "%'";
            }
            // 判断地址是否为空
            if (offers.getAddress() != null && !"".equals(offers.getAddress())) {
                sql += " and Address like '%" + offers.getAddress() + "%'";
            }
            // 判断电话是否为空
            if (offers.getTel() != null && !"".equals(offers.getTel())) {
                sql += " and Tel like '%" + offers.getTel() + "%'";
            }
            ResultSet resultSet = super.executeQuery(sql);
            while (resultSet.next()) {
                Offers offers1 = new Offers();
                offers1.setOfferId(resultSet.getInt("OfferID"));
                offers1.setOfferName(resultSet.getString("OfferName"));
                offers1.setLegalIp(resultSet.getString("LegalIP"));
                offers1.setAddress(resultSet.getString("Address"));
                offers1.setTel(resultSet.getString("Tel"));
                list.add(offers1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    /**
     * 判断id是否存在
     *
     * @param offerId  供货商id
     * @return 返回布尔值
     */
    @Override
    public boolean isExist(int offerId) {
        boolean flag = false;
        try {
            super.getConnection();
            // sql语句 判断id是否存在
            String sql = "select * from Offers where OfferID = ?";
            ResultSet rs = super.executeQuery(sql, offerId);
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            super.connClose();
        }
        return flag;
    }


    /**
     * 查询所有供货商
     *
     * @return 返回供货商集合
     */
    @Override
    public List<Offers> queryAllOffers() {
        List<Offers> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句 查询所有供货商
            String sql = "select * from Offers";
            ResultSet resultSet = super.executeQuery(sql);
            while (resultSet.next()) {
                Offers offers = new Offers();
                offers.setOfferId(resultSet.getInt("OfferID"));
                offers.setOfferName(resultSet.getString("OfferName"));
                offers.setLegalIp(resultSet.getString("LegalIP"));
                offers.setAddress(resultSet.getString("Address"));
                offers.setTel(resultSet.getString("Tel"));
                list.add(offers);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 根据id查询供货商
     *
     * @param offerId 供货商id
     * @return 返回供货商对象
     */

    public Offers queryOffersById(int offerId) {
        Offers offers = null;
        try {
            super.getConnection();
            // sql语句 根据id查询供货商
            String sql = "select * from Offers where OfferID = ?";
            ResultSet resultSet = super.executeQuery(sql, offerId);
            if (resultSet.next()) {
                offers = new Offers();
                offers.setOfferId(resultSet.getInt("OfferID"));
                offers.setOfferName(resultSet.getString("OfferName"));
                offers.setLegalIp(resultSet.getString("LegalIP"));
                offers.setAddress(resultSet.getString("Address"));
                offers.setTel(resultSet.getString("Tel"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            super.connClose();
        }
        return offers;
    }
}
