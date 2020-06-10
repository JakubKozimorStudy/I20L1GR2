package com.l1gr2.restaurant.repository;

import com.l1gr2.restaurant.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> getOrdersByStatusContaining(String slowo);

    @Query("select Id from Orders order by Id asc")
    List<Object[]> getLastId();
}
