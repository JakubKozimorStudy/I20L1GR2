package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Products;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsService {

    List<Products> getAllProducts();

    List<Products> findByNames(String name);

    void updateProduct(Products selectedItem, int quantity);


}
