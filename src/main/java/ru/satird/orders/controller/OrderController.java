package ru.satird.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.satird.orders.dao.GoodsDaoImpl;
import ru.satird.orders.domain.Goods;
import ru.satird.orders.domain.Order;
import ru.satird.orders.service.GoodsService;
import ru.satird.orders.service.OrderService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    GoodsService goodsService;

    @GetMapping("order-list")
    public List<Order> list() {
        return orderService.getOrders();
    }

    @PostMapping("save-order")
    public void createOrder(
            @RequestBody Order order
    ) {
        orderService.saveOrder(order);
    }

    @PostMapping("update-order/{id}")
    public void updateOrder(
            @PathVariable("id") long id,
            @RequestBody Order order
    ) {
        order.setId(id);
        orderService.updateOrder(order);
    }

    @DeleteMapping("delete-order/{id}")
    public void deleteOrder(@PathVariable("id") long id,
                            Order order
    ) {
        order.setId(id);
        orderService.deleteOrder(order);
    }

    @GetMapping("order/{id}")
    public List<Order> allOrderById(
            @PathVariable("id") long id,
            Order order
    ) {
        order.setId(id);
        return orderService.getOrderByID(order);
    }

    @GetMapping("goods-list")
    public List<Goods> listGoodsAll() {
        return goodsService.getGoods();
    }

    @PostMapping("save-goods")
    public void createGoods(
            @RequestBody Goods goods
    ) {
        goodsService.saveGoods(goods);
    }

    @PostMapping("update-goods/{id}")
    public void updateGoods(
            @PathVariable("id") long id,
            @RequestBody Goods goods
    ) {
        goods.setId(id);
        goodsService.updateGoods(goods);
    }

    @DeleteMapping("delete-goods/{id}")
    public void deleteGoods(
            @PathVariable("id") long id,
            Goods goods
    ) {
        goods.setId(id);
        goodsService.deleteGoods(goods);
    }

    @GetMapping("goods/{id}")
    public List<Goods> allGoodsById(
            @PathVariable("id") long id,
            Goods goods
    ) {
        goods.setId(id);
        return goodsService.getGoodsByID(goods);
    }
}
