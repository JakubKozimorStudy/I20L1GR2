package com.l1gr2.restaurant.reports;

import com.l1gr2.restaurant.entity.Users;
import reports.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class DishTypeMapper {
    public List<Dish> getDishesToReports(List<com.l1gr2.restaurant.entity.Dish> dishes) {
        return dishes.stream()
                .map(dish -> new reports.Dish(dish.getId(),dish.getName(),dish.getDescripion(),dish.getPrice(),dish.getCategory()))
                .collect(Collectors.toList());
    }
}
