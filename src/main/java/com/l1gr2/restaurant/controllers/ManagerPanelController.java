package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.RestaurantApplication;
import com.l1gr2.restaurant.SceneManager;
import com.l1gr2.restaurant.entity.Dish;
import com.l1gr2.restaurant.entity.Inventory;
import com.l1gr2.restaurant.service.DishService;
import com.l1gr2.restaurant.service.ProductsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;
/**
 * author Krzysztof Krupinski
 * Klasa odpowiedzialna za zwracanie produktów, dań i raportów
 */
@Controller
public class ManagerPanelController {

    @FXML
    public TableView <Inventory> mn_tbl_products;

    @FXML
    public TableColumn<Inventory, String> mn_column_product;

    @FXML
    public TableColumn<Inventory, String> mn_column_count;

    @FXML
    public TableView <Inventory> mn_tbl_raports;

    @FXML
    public TableColumn<Inventory, String> mn_column_rap;

    @FXML
    public TableColumn<Inventory, String> mn_column_data;

    @FXML
    public TableView <Dish> mn_tbl_dish;

    @FXML
    public TableColumn<Dish, String> mn_column_dish;

    @FXML
    public TableColumn<Dish, String> mn_column_prod_dish;

    @FXML
    public TableColumn<Dish, String> mn_column_price;

    @FXML
    public TextField add_prod_prod;

    @FXML
    public TextField add_prod_count;

    @FXML
    public TextField add_dish_dish;

    @FXML
    public TextField add_dish_prod;

    @FXML
    public TextField add_dish_price;

    @FXML
    public Button add_dish;

    @FXML
    public Button add_prod;

    private ProductsService productsService;
    private DishService dishService;
    ObservableList<Inventory> observableListAllProducts = FXCollections.observableArrayList();
    ObservableList<Dish> obsevableListAllDishes = FXCollections.observableArrayList();

    public ObservableList<Inventory> getObservableListAllProducts() {
        List<Inventory> productsList = productsService.getAllProducts();
        this.observableListAllProducts.addAll(productsList);
        return this.observableListAllProducts;
    }
    /**
     * metoda odświeża listę produktów po jej edytowaniu( dodaniu lub usunięciu użytkownika)
     */
    public void refresh_products_table() {
        this.observableListAllProducts = FXCollections.observableArrayList();
        mn_tbl_products.getColumns().clear();
        mn_tbl_products.setItems(getObservableListAllProducts());
        mn_tbl_products.getColumns().addAll(mn_column_product, mn_column_count);
    }

    public ObservableList<Dish> getObservableListAllDishes(){
        List<Dish> dishList = dishService.getAllDish();
        this.obsevableListAllDishes.addAll(dishList);
        return this.obsevableListAllDishes;
    }

    /**
     *
     * @param event, kliknięcie
     *               metoda odpowiedzialna za wylogowanie użytkownika i przeniesienie go na strone logowania
     */

    @FXML
    void logoutButton(ActionEvent event) {
        SceneManager.renderScene("loginPage");
    }

    /**
     *
     * @param event, kliknięcie
     *               metoda odpowiedzialna za przeniesienie do panelu listy użytkowników
     */
    @FXML
    void ListOfKelnersButton(ActionEvent event) { SceneManager.renderScene("listOfUsers");}

    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = RestaurantApplication.getSpringContext();
        dishService = (DishService) springContext.getBean("dishService");
        productsService = (ProductsService) springContext.getBean("productsServiceImpl");

        mn_column_dish.setCellValueFactory(new PropertyValueFactory<>("name"));
        mn_column_prod_dish.setCellValueFactory(new PropertyValueFactory<>("descripion"));
        mn_column_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        mn_tbl_dish.getColumns().clear();
        mn_tbl_dish.setItems(getObservableListAllDishes());
        mn_tbl_dish.getColumns().addAll(mn_column_dish, mn_column_prod_dish,mn_column_price);

        mn_column_product.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        mn_column_count.setCellValueFactory(new PropertyValueFactory<>("product_quantity"));
        mn_tbl_products.getColumns().clear();
        mn_tbl_products.setItems(getObservableListAllProducts());
        mn_tbl_products.getColumns().addAll(mn_column_product, mn_column_count);

    }
}