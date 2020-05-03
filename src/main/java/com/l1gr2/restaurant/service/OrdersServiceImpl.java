package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Orders;
import com.l1gr2.restaurant.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository){this.ordersRepository = ordersRepository;}

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public void updateProduct(Orders order) {

        ordersRepository.save(order);
    }
}
