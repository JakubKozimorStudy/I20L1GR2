package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Dish;
import com.l1gr2.restaurant.entity.Orders;
import com.l1gr2.restaurant.repository.OrdersRepository;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTests {

    @Mock
    OrdersRepository ordersRepository;

    @InjectMocks
    OrdersServiceImpl ordersService;


    @Test
    public void shouldGetAllOrders() {
        // given
        given(ordersRepository.findAll()).willReturn(prepareData());
        // when
        List<Orders> listOfOrders = ordersService.getAllOrders();
        // then
        assertThat(listOfOrders, hasSize(6));
    }

    @Test
    public void shouldUpdateProduct() {
        // given
        Orders order = prepareData().get(0);
        order.setStatus("gotowe");
        // when
        ordersService.updateProduct(order);
        // then
        assertThat(prepareData(), hasSize(6));
    }

    private List<Orders> prepareData() {
        Orders order1 = new Orders(1, Date.valueOf(LocalDate.now()), 1, "zamówione", new Dish());
        Orders order2 = new Orders();
        Orders order3 = new Orders();
        Orders order4 = new Orders();
        Orders order5 = new Orders();
        Orders order6 = new Orders();
        return Arrays.asList(order1, order2, order3, order4, order5, order6);
    }
}
