package ru.satird.orders.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.satird.orders.domain.Goods;
import ru.satird.orders.domain.Order;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class DaoImplTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenInvalidId_thenReturnNull() {
        Order fromDb = entityManager.find(Order.class, -11l);
        assertThat(fromDb).isNull();
    }

    @Test
    public void whenFindById_thenReturnOrder() {
        Order order = new Order("Client", new Date(), "Address" );
        entityManager.persistAndFlush(order);

        Order found = entityManager.find(Order.class, 2L);
        assertThat(found.getAddress()).isEqualTo(order.getAddress());
        assertThat(found.getAddress()).isEqualTo("Address");
        entityManager.flush();
    }

    @Test
    public void whenFindById_thenReturnGoods() {
        Goods goods = new Goods("Name",  15d );
        entityManager.persistAndFlush(goods);

        Goods found = entityManager.find(Goods.class, 1L);
        assertThat(found.getPrice()).isEqualTo(goods.getPrice());
        assertThat(found.getName()).isEqualTo("Name");
    }

}