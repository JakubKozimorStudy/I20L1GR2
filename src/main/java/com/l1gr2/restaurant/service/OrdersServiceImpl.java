package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Orders;
import com.l1gr2.restaurant.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    OrdersRepository ordersRepository;

    int lastone;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository){this.ordersRepository = ordersRepository;}

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.getOrdersByStatusContaining("Do realizacji");
    }

    @Override
    public void updateProduct(Orders order) {
        ordersRepository.save(order);
    }

    @Override
    public void addOrder(Orders order) { ordersRepository.save(order); }

    @Override
    public int lastId() {

        for (Object[] obj : ordersRepository.getLastId()){
            String xd = String.valueOf(obj[0]);
           lastone = Integer.parseInt(xd);
        }
        return lastone;
    }
}
