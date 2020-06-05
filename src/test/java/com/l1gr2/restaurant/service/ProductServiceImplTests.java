package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Inventory;
import com.l1gr2.restaurant.repository.ProductsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTests {

    @Mock
    ProductsRepository productsRepository;

    @InjectMocks
    ProductsServiceImpl productsService;

    @Test
    public void shouldGetAllProducts() {
        // given
        given(productsRepository.findAll()).willReturn(prepareData());
        // when
        List<Inventory> listOfProducts = productsService.getAllProducts();
        // then
        assertThat(listOfProducts, hasSize(5));
    }

    @Test
    public void shouldFindByNames() {
        // given
        given(productsRepository.findByname("name")).willReturn(Arrays.asList(prepareData().get(0), prepareData().get(4)));
        // when
        List<Inventory> filteredList = productsService.findByNames("name");
        // then
        assertThat(filteredList, hasSize(2));
    }

    @Test
    public void updateProduct() {
        // given
        Inventory product = new Inventory(1, "Kawa", 1, 4);
        // when
        productsService.updateProduct(product, 23);
        // then
        assertThat(product.getProduct_quantity(), is(equalTo(23)));
    }

    private List<Inventory> prepareData() {
        Inventory inventory1 = new Inventory();
        Inventory inventory2 = new Inventory();
        Inventory inventory3 = new Inventory();
        Inventory inventory4 = new Inventory();
        Inventory inventory5 = new Inventory();
        return Arrays.asList(inventory1, inventory2, inventory3, inventory4, inventory5);
    }
}
