package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Inventory;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsService {

    List<Inventory> getAllProducts();

    List<Inventory> findByNames(String name);

    void updateProduct(Inventory selectedItem, int quantity);


}
