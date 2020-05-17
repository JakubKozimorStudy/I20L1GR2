package com.l1gr2.restaurant.repository;

import com.l1gr2.restaurant.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,Integer> {
}
