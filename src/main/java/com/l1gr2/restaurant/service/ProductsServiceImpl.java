package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Inventory;
import com.l1gr2.restaurant.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    ProductsRepository productsRepository;

    @Autowired
    public ProductsServiceImpl(ProductsRepository productsRepository){this.productsRepository = productsRepository;}

    /**
     * @return zwraca listę wszystkich produktów
     */
    @Override
    public List<Inventory> getAllProducts() {
        return productsRepository.findAll();
    }

    /**
     * @param name przujmuje jako parametr nazwę produktu
     * @return zwraca informacje o produkcie
     */
    @Override
    public List<Inventory> findByNames(String name){return productsRepository.findByname(name);}

    /**
     * @param product przyjmuje jako parametr obiekt
     * @param quantity aktualizuje ilość produktu
     */
    @Override
    public void updateProduct(Inventory product, int quantity) {

        product.setProduct_quantity(quantity);
        productsRepository.save(product);
    }

}
