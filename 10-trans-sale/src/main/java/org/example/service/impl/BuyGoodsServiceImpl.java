package org.example.service.impl;

import org.apache.ibatis.binding.BindingException;
import org.example.beans.Goods;
import org.example.beans.Sale;
import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.excep.NotEnoughException;
import org.example.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    //定义Dao的依赖对象
    private GoodsDao goodsDao;
    private SaleDao saleDao;

    //设置注入

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    //实现接口中的方法
    @Override
    public void buyGoods(Integer goodsId, Integer nums) throws NullPointerException, NotEnoughException{
        //生成sale订单
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        //修改库存
        Goods goods = goodsDao.selectGoodsById(goodsId);
        if(goods == null)
        {
            //没有商品
            throw new NullPointerException(goodsId+" 没有，不存在");
        }
       if(goods.getAmount()<nums)
       {
           //库存不足
            throw new NotEnoughException(goodsId+" 库存不足");
       }

       //库存操作
       goods.setAmount(nums);
       goodsDao.updateGoods(goods);


    }
}
