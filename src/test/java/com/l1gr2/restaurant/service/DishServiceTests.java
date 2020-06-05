package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Dish;
import com.l1gr2.restaurant.repository.DishRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class DishServiceTests {

    @Mock
    DishRepository dishRepository;

    @InjectMocks
    DishService dishService;

    @Test
    public void shouldGetAllDish() {
        // given
        given(dishRepository.findAll()).willReturn(prepareData());
        // when
        List<Dish> listOfDish = dishService.getAllDish();
        // then
        assertThat(listOfDish, hasSize(4));
    }

    private List<Dish> prepareData() {
        Dish dish1 = new Dish();
        Dish dish2 = new Dish();
        Dish dish3 = new Dish();
        Dish dish4 = new Dish();
        return Arrays.asList(dish1, dish2, dish3, dish4);
    }
}
