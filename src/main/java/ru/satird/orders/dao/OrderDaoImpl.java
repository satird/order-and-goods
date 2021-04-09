package ru.satird.orders.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.satird.orders.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> getOrder(long id) {
        List<Order> listOrder = new ArrayList<>();
        Order orderById =entityManager.find(Order.class, id);
        listOrder.add(orderById);
        return listOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        return entityManager.createQuery("from " + Order.class.getSimpleName()).getResultList();
    }

    @Override
    public boolean saveOrder(Order order) {
        boolean status = false;
        try {
            entityManager.persist(order);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateOrder(Order order) {
        boolean status = false;
        try {
            entityManager.merge(order);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    @Override
    public boolean deleteOrder(Order order) {
        boolean status = false;
        try {
            entityManager.remove(entityManager.contains(order) ? order : entityManager.merge(order));
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
