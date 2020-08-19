package org.example.dao;

import org.example.beans.Sale;

public interface SaleDao {

    //生成订单
    int insertSale(Sale sale);

}
