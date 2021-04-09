package ru.satird.orders.service;

import ru.satird.orders.domain.Order;

import java.util.List;

public interface OrderService {
    public boolean saveOrder(Order order);
    public List<Order> getOrders();
    public boolean deleteOrder(Order order);
    public List<Order> getOrderByID(Order order);
    public boolean updateOrder(Order order);
}
