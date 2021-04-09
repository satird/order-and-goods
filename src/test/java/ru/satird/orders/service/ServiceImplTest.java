package ru.satird.orders.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.satird.orders.OrdersApplication;
import ru.satird.orders.controller.JsonUtil;
import ru.satird.orders.domain.Order;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = OrdersApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
class ServiceImplTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrderService orderServiceImpl;

    @Test
    public void whenValidInput_thenCreateOrder() throws IOException, Exception {
        Order myOrder = new Order("Client", new Date(), "Address");
        mvc.perform(post("/api/save-order").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(myOrder)));

        List<Order> found = orderServiceImpl.getOrders();
        assertThat(found).extracting(Order::getClient).contains("Client");
        mvc.perform(delete("/api/delete-order/" + found.get(found.size()-1).getId()));
    }

}