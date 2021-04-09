package ru.satird.orders.dao;

import org.springframework.stereotype.Repository;
import ru.satird.orders.domain.Goods;
import ru.satird.orders.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Goods> getGoods(long id) {
        List<Goods> listGoods = new ArrayList<>();
        Goods goodsById =entityManager.find(Goods.class, id);
        listGoods.add(goodsById);
        return listGoods;
    }

    @Override
    public List<Goods> getAllGoods() {
        return entityManager.createQuery("from " + Goods.class.getSimpleName()).getResultList();
    }

    @Override
    public boolean saveGoods(Goods goods) {
        boolean status = false;
        try {
            entityManager.persist(goods);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        boolean status = false;
        try {
            entityManager.merge(goods);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean deleteGoods(Goods goods) {
        boolean status = false;
        try {
            entityManager.remove(entityManager.contains(goods) ? goods : entityManager.merge(goods));
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
