package com.song.dao.impl;

import com.song.dao.OffersDao;
import com.song.entity.Offers;

import java.util.ArrayList;
import java.util.List;

public class OffersDaoimpl extends BaseDao implements OffersDao {

    /**
     * 添加供货商
     * @param offers
     * @return
     */
    @Override
    public int addOffers(Offers offers) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "insert into Offers values(?,?,?,?,?)";
             Object[] params = {offers.getOfferID(),offers.getOfferName(),offers.getLegalIP(),offers.getAddress(),offers.getTel()};
                count = super.executeUpdate(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public int deleteOffers(int OfferID) {
       int count = 0;
         try {
              super.getConnection();
              String sql = "delete from Offers where OfferID = ?";
              Object[] params = {OfferID};
              count = super.executeUpdate(sql,params);
            }catch (Exception e){
              throw new RuntimeException(e);
            }
         return  count;
    }

    @Override
    public int updateOffers(Offers offers) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "update Offers set OfferName = ?,LegalIP = ?,Address = ?,Tel = ? where OfferID = ?";
            Object[] params = {offers.getOfferName(),offers.getLegalIP(),offers.getAddress(),offers.getTel(),offers.getOfferID()};
            count = super.executeUpdate(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public List<Offers> queryOffers() {
       List<Offers> list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Offers";
            Object[] params = {};
            super.executeQuery(sql,params);
            while (rs.next()){
                Offers offers = new Offers();
                offers.setOfferID(rs.getString("OfferID"));
                offers.setOfferName(rs.getString("OfferName"));
                offers.setLegalIP(rs.getString("LegalIP"));
                offers.setAddress(rs.getString("Address"));
                offers.setTel(rs.getString("Tel"));
                list.add(offers);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return list;
    }
}
