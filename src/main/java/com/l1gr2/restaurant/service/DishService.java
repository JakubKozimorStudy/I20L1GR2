package com.l1gr2.restaurant.service;
import com.l1gr2.restaurant.entity.Dish;
import com.l1gr2.restaurant.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDish() {
        return dishRepository.findAll();
    }
}

