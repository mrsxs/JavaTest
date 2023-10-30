package com.song.dao;

import com.song.entity.Goods;

import java.util.List;

public interface GoodsDao {
    // 添加商品
    public int addGoods(Goods goods);

    // 删除商品
    public int deleteGoods(int id);

    // 修改商品
    public int updateGoods(Goods goods);

    // 查询商品
    public List<Goods> selectGoods();

    //多条件查询商品
    public List<Goods> CompoundQuery(Goods goods);

    // 根据判断id是否存在
    public boolean isExist(int id);

    // 根据id查询商品
    public Goods queryGoodsById(int id);

}
