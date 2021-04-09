package ru.satird.orders.dao;

import ru.satird.orders.domain.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrder(long id);
    List<Order> getAllOrders();
    boolean saveOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(Order order);
}
