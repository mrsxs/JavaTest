package com.song.dao;

import com.song.entity.Goods;

import java.util.List;

/**
 * 商品的数据库操作类
 * @author song
 */

public interface GoodsDao {

    /**
     * 添加商品
     * 
     * @param goods 商品对象
     * @return 返回受影响的行数
     */
    public int addGoods(Goods goods);

    /**
     * 删除商品
     * 
     * @param id 商品id
     * @return 返回受影响的行数
     */
    public int deleteGoods(int id);

    /**
     * 修改商品
     * 
     * @param goods 商品对象
     * @return 返回受影响的行数
     */
    public int updateGoods(Goods goods);

    /**
     * 查询所有商品
     * 
     * @return 返回商品集合
     */
    public List<Goods> selectGoods();

    /**
     * 多条件查询
     * 
     * @param goods 商品对象
     * @return 返回商品集合
     */
    public List<Goods> compoundQuery(Goods goods);

   /**
    * 判断id是否存在
    * @param id 商品id
    * @return 返回布尔值
    */
    public boolean isExist(int id);

   /**
    * 根据id查询商品
    * @param id 商品id
    * @return 返回商品对象
    */
    public Goods queryGoodsById(int id);

}
