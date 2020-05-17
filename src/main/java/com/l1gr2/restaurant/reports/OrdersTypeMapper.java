package com.l1gr2.restaurant.reports;

import reports.Dish;
import reports.Orders;

import java.util.List;
import java.util.stream.Collectors;

public class OrdersTypeMapper {
    public List<Orders> getOrdersToReports(List<com.l1gr2.restaurant.entity.Orders> orders) {
        return orders.stream()
                .map(order -> new reports.Orders(order.getDate(), order.getQuantity(), order.getStatus(), new Dish(order.getDish().getId(), order.getDish().getName(), order.getDish().getDescripion(), order.getDish().getPrice(), order.getDish().getCategory())))
                .collect(Collectors.toList());
    }
}
