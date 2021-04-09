package ru.satird.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.satird.orders.dao.OrderDao;
import ru.satird.orders.domain.Order;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public boolean saveOrder(Order order) {
        return orderDao.saveOrder(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public boolean deleteOrder(Order order) {
        return orderDao.deleteOrder(order);
    }

    @Override
    public List<Order> getOrderByID(Order order) {
        return orderDao.getOrder(order.getId());
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }
}
