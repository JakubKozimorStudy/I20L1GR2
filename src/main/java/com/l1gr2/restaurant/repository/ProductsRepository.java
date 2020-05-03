package com.l1gr2.restaurant.repository;

import com.l1gr2.restaurant.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    @Query("select p from Products p where p.name like CONCAT(:name,'%')")
    List<Products> findByname(@Param("name") String name);
}
