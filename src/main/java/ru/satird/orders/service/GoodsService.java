package ru.satird.orders.service;

import ru.satird.orders.domain.Goods;

import java.util.List;

public interface GoodsService {
    public boolean saveGoods(Goods goods);
    public List<Goods> getGoods();
    public boolean deleteGoods(Goods goods);
    public List<Goods> getGoodsByID(Goods goods);
    public boolean updateGoods(Goods goods);
}
