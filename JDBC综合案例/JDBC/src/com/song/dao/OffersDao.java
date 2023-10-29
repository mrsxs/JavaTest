package com.song.dao;

import com.song.entity.Offers;

import java.util.List;

public interface OffersDao {

        /**
        * 添加供货商
        */
        public int addOffers(Offers offers);

        /**
        * 删除供货商
        */

        public int deleteOffers(int OfferID);

        /**
        * 修改供货商
        */
        public int updateOffers(Offers offers);
        /**
         * 查询所有供货商
         */

        /**
         * 多条件查询
         */
        public List<Offers> queryOffers(Offers offers);

        /**
         * 判断id是否存在
         */
        public boolean isExist(int OfferID);
        /**
         * 查询所有供货商
         */
        public List<Offers> queryAllOffers();
}
