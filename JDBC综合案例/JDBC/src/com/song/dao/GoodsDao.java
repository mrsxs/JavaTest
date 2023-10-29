package com.song.dao.impl;

public interface GoodsDao {
    // 添加商品
    public void addGoods();
    // 删除商品
    public void deleteGoods();
    // 修改商品
    public void updateGoods();
    // 查询商品
    public void selectGoods();
    //多条件查询商品
    public void selectGoodsByCondition();

}
