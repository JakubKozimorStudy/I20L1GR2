package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Orders;
import com.l1gr2.restaurant.entity.Users;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrdersService {

    List<Orders> getAllOrders();

    void updateProduct(Orders order);

    void addOrder(Orders order);

    int lastId();
}
