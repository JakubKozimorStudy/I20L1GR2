package com.l1gr2.restaurant.repository;

import com.l1gr2.restaurant.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Inventory, Integer> {

    @Query("select p from Inventory p where p.product_name like CONCAT(:product_name,'%')")
    List<Inventory> findByname(@Param("product_name") String product_name);
}
