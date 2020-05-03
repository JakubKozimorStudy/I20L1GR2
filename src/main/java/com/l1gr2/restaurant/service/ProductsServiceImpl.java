package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Products;
import com.l1gr2.restaurant.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    ProductsRepository productsRepository;

    @Autowired
    public ProductsServiceImpl(ProductsRepository productsRepository){this.productsRepository = productsRepository;}

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public List<Products> findByNames(String name){return productsRepository.findByname(name);}

    @Override
    public void updateProduct(Products product, int quantity) {

        product.setQuantity(quantity);
        productsRepository.save(product);
    }

}
