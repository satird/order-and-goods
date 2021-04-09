package ru.satird.orders.dao;

import ru.satird.orders.domain.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> getGoods(long id);
    List<Goods> getAllGoods();
    boolean saveGoods(Goods goods);
    boolean updateGoods(Goods goods);
    boolean deleteGoods(Goods goods);
}
