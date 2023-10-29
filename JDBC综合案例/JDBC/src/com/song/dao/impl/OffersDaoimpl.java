package com.song.dao.impl;

import com.song.dao.OffersDao;
import com.song.entity.Offers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffersDaoimpl extends BaseDao implements OffersDao {

    /**
     * 添加供货商
     *
     * @param offers
     * @return
     */
    @Override
    public int addOffers(Offers offers) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "insert into Offers(OfferName,LegalIP,Address,Tel) values(?,?,?,?)";
            Object[] params = {offers.getOfferName(), offers.getLegalIP(), offers.getAddress(), offers.getTel()};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    /**
     * 删除供货商
     *
     * @param OfferID
     * @return
     */

    @Override
    public int deleteOffers(int OfferID) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "delete from Offers where OfferID = ?";
            Object[] params = {OfferID};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    /**
     * 修改供货商
     *
     * @param offers
     * @return
     */
    @Override
    public int updateOffers(Offers offers) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "update Offers set OfferName = ?,LegalIP = ?,Address = ?,Tel = ? where OfferID = ?";
            Object[] params = {offers.getOfferName(), offers.getLegalIP(), offers.getAddress(), offers.getTel(), offers.getOfferID()};
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    /**
     * 多条件查询
     *
     * @return
     */

    @Override
    public List<Offers> queryOffers(Offers offers) {
        List<Offers> list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Offers where 1=1";
            if (offers.getOfferID() != 0) {
                sql += " and OfferID = " + offers.getOfferID();
            }
            if (offers.getOfferName() != null && !"".equals(offers.getOfferName())) {
                sql += " and OfferName like '%" + offers.getOfferName() + "%'";
            }
            if (offers.getLegalIP() != null && !"".equals(offers.getLegalIP())) {
                sql += " and LegalIP like '%" + offers.getLegalIP() + "%'";
            }
            if (offers.getAddress() != null && !"".equals(offers.getAddress())) {
                sql += " and Address like '%" + offers.getAddress() + "%'";
            }
            if (offers.getTel() != null && !"".equals(offers.getTel())) {
                sql += " and Tel like '%" + offers.getTel() + "%'";
            }
            ResultSet resultSet = super.executeQuery(sql);
            while (resultSet.next()) {
                Offers offers1 = new Offers();
                offers1.setOfferID(resultSet.getInt("OfferID"));
                offers1.setOfferName(resultSet.getString("OfferName"));
                offers1.setLegalIP(resultSet.getString("LegalIP"));
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
     * @param OfferID
     * @return
     */
    @Override
    public boolean isExist(int OfferID) {
        boolean flag = false;
        try {
            super.getConnection();
            String sql = "select * from Offers where OfferID = ?";
            Object[] params = {OfferID};
            ResultSet rs = super.executeQuery(sql, params);
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }


    /**
     * 查询所有供货商
     *
     * @return
     */
    @Override
    public List<Offers> queryAllOffers() {
        List<Offers> list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Offers";
            ResultSet resultSet = super.executeQuery(sql);
            while (resultSet.next()) {
                Offers offers = new Offers();
                offers.setOfferID(resultSet.getInt("OfferID"));
                offers.setOfferName(resultSet.getString("OfferName"));
                offers.setLegalIP(resultSet.getString("LegalIP"));
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
     * @param offerID
     * @return
     */

    public Offers queryOffersById(int offerID) {
        Offers offers = null;
        try {
            super.getConnection();
            String sql = "select * from Offers where OfferID = ?";
            Object[] params = {offerID};
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                offers = new Offers();
                offers.setOfferID(resultSet.getInt("OfferID"));
                offers.setOfferName(resultSet.getString("OfferName"));
                offers.setLegalIP(resultSet.getString("LegalIP"));
                offers.setAddress(resultSet.getString("Address"));
                offers.setTel(resultSet.getString("Tel"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return offers;
    }
}
