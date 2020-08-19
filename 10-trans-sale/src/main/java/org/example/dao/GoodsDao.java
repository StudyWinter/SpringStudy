package org.example.dao;

import org.example.beans.Goods;

public interface GoodsDao {

    //查询商品
    Goods selectGoodsById(Integer id);

    //更新库存,goods就是本次购买商品的数据，购买数量。
    int updateGoods(Goods goods);
}
