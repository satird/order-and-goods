package ru.satird.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.satird.orders.dao.GoodsDao;
import ru.satird.orders.domain.Goods;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public boolean saveGoods(Goods goods) {
        return goodsDao.saveGoods(goods);
    }

    @Override
    public List<Goods> getGoods() {
        return goodsDao.getAllGoods();
    }

    @Override
    public boolean deleteGoods(Goods goods) {
        return goodsDao.deleteGoods(goods);
    }

    @Override
    public List<Goods> getGoodsByID(Goods goods) {
        return goodsDao.getGoods(goods.getId());
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }
}
