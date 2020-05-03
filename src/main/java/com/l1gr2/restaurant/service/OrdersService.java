package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> getAllOrders();

    void updateProduct(Orders order);
}
