package com.song.dao;

import com.song.entity.Offers;

import java.util.List;

/**
 * 供货商的数据库操作类
 * 
 * @Author song
 */

public interface OffersDao {

    /**
     * 添加供货商
     * 
     * @param offers 供货商对象
     * @return 返回受影响的行数
     */
    public int addOffers(Offers offers);

    /**
     * 删除供货商
     * 
     * @param offerId 供货商id
     * @return 返回受影响的行数
     */

    public int deleteOffers(int offerId);

    /**
     * 修改供货商
     * 
     * @param offers 供货商对象
     * @return 返回受影响的行数
     */
    public int updateOffers(Offers offers);

    /**
     * 多条件查询
     * @param offers 供货商对象
     * @return 返回供货商集合
     */
    public List<Offers> queryOffers(Offers offers);

    /**
     * 判断id是否存在
     * @param offerId 供货商id
     * @return 返回布尔值
     */
    public boolean isExist(int offerId);

    /**
     * 查询所有供货商
     * @return 返回供货商集合
     * 
     */
    public List<Offers> queryAllOffers();

    /**
     * 根据id查询供货商
     * @param offerId 供货商id
     * @return 返回供货商对象
     */
    public Offers queryOffersById(int offerId);
}
