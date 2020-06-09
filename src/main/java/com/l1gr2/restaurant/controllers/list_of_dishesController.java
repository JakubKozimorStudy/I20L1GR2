package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.RestaurantApplication;
import com.l1gr2.restaurant.SceneManager;
import com.l1gr2.restaurant.entity.Dish;
import com.l1gr2.restaurant.service.DishService;
import com.l1gr2.restaurant.tables.Tables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
/**
 * Klasa odpowiedzialna za zwracanie listy dań
 */
public class list_of_dishesController {

    private DishService dishService;
    ObservableList<Dish> obsevableListAllDishes = FXCollections.observableArrayList();
    ObservableList<Dish> obsevableListAllOrderedDishes = FXCollections.observableArrayList();


    @FXML
    private TableView<Dish> menu;

    @FXML
    private TableColumn<Dish, String> name;

    @FXML
    private TableColumn<Dish, Integer> price;

    @FXML
    private TableView<Dish> order;

    @FXML
    private TableColumn<Dish, String> NameInOrder;

    @FXML
    private TableColumn<Dish, Integer> PriceInOrder;

    /**
     * @param event , kliknięcie
     *              Metoda dodająca nową potrawę do menu
     */
    @FXML
    void add(ActionEvent event) {
        Tables.getActualTable().add(menu.getSelectionModel().getSelectedItem());
        initializeOrder();
    }
    /**
     * @param event , kliknięcie
     *              Metoda usuwająca wybraną potrawe z zamówienia
     */
    @FXML
    void delete(ActionEvent event) {
        Tables.getActualTable().remove(order.getSelectionModel().getSelectedItem());
        initializeOrder();
    }
    /**
     * @param event , kliknięcie
     *              Metoda czyszcząca dane zamówienie
     */
    @FXML
    void clean(ActionEvent event) {
        Tables.getActualTable().clear();
        initializeOrder();
    }
    /**
     * @param event , kliknięcie
     *              Metoda czyszcząca dane zamówienie po zapłacie
     */
    @FXML
    void pay(ActionEvent event) {
        Tables.getActualTable().clear();
        initializeOrder();
    }
    /**
     *
     * @param event, kliknięcie
     *               metoda odpowiedzialna za wylogowanie użytkownika i przeniesienie go na strone logowania
     */
    @FXML
    void cancel(ActionEvent event) {
        SceneManager.renderScene("tables-page");
    }

    public ObservableList<Dish> getObservableListAllDishes(){
        List<Dish> dishList = dishService.getAllDish();
        this.obsevableListAllDishes.addAll(dishList);
        return this.obsevableListAllDishes;
    }
    public ObservableList<Dish> getObservableListOrderedDishes(){
        this.obsevableListAllOrderedDishes.addAll(Tables.getActualTable());
        return this.obsevableListAllOrderedDishes;
    }
    /**
     * metoda dodająca danie z menu do zamówienia
     */
    void initializeOrder() {
        this.obsevableListAllOrderedDishes = FXCollections.observableArrayList();
        order.getColumns().clear();
        order.setItems(getObservableListOrderedDishes());
        order.getColumns().addAll(NameInOrder,PriceInOrder);
    }



    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = RestaurantApplication.getSpringContext();
        dishService = (DishService) springContext.getBean("dishService");

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        menu.getColumns().clear();
        menu.setItems(getObservableListAllDishes());
        menu.getColumns().addAll(name,price);


        NameInOrder.setCellValueFactory(new PropertyValueFactory<>("name"));
        PriceInOrder.setCellValueFactory(new PropertyValueFactory<>("price"));
        order.getColumns().clear();
        order.setItems(getObservableListOrderedDishes());
        order.getColumns().addAll(NameInOrder,PriceInOrder);
    }
}