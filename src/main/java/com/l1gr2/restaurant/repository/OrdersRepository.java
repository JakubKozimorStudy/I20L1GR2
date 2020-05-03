package com.l1gr2.restaurant.repository;

import com.l1gr2.restaurant.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
