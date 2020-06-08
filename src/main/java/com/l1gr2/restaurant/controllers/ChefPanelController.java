package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.RestaurantApplication;
import com.l1gr2.restaurant.SceneManager;
import com.l1gr2.restaurant.entity.Dish;
import com.l1gr2.restaurant.entity.Orders;
import com.l1gr2.restaurant.entity.Inventory;
import com.l1gr2.restaurant.repository.ProductsRepository;
import com.l1gr2.restaurant.service.OrdersService;
import com.l1gr2.restaurant.service.ProductsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Klasa odpowiedzialna za zwracanie produktów i zamówień
 */
@Controller
public class ChefPanelController {


    @FXML
    private TableView<Inventory> tbl_products;

    @FXML
    private TableColumn<Inventory, String> column_product;

    @FXML
    private TableColumn<Inventory, String> column_count;

    @FXML
    private TableView<Inventory> tbl_used_products;

    @FXML
    private TableColumn<Inventory, String> column_used_product;

    @FXML
    private TableColumn<Inventory, String> column_used_count;

    @FXML
    private TextField text_product;

    @FXML
    private ComboBox choice_products;

    @FXML
    private TableView<Orders> tbl_dishes;

    @FXML
    private TableColumn<Orders, Dish> column_dish;

    @FXML
    private TableColumn<Orders, String> column_status;

    @FXML
    private ChoiceBox choice_status;

    List<Inventory> used_products = new ArrayList<Inventory>();
    List<Integer> help_list = new ArrayList<Integer>();


    private ProductsService productsService;
    private OrdersService ordersService;

    ObservableList<Inventory> observableListAllProducts = FXCollections.observableArrayList();
    ObservableList<Inventory> observableListUsedProducts = FXCollections.observableArrayList();
    ObservableList<Inventory> observableListSearchedProducts = FXCollections.observableArrayList();

    ObservableList<Orders> observableListAllOrders = FXCollections.observableArrayList();
    ObservableList<Integer> values = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30);
    ObservableList<String> valuesStatus = FXCollections.observableArrayList("W realizacji", "Gotowe", "Odrzucono");

    public ObservableList<Inventory> getObservableListAllProducts() {
        List<Inventory> productsList = productsService.getAllProducts();
        this.observableListAllProducts.addAll(productsList);
        return this.observableListAllProducts;
    }

    public ObservableList<Orders> getObservableListAllOrders(){
        List<Orders> ordersList = ordersService.getAllOrders();
        this.observableListAllOrders.addAll(ordersList);
        return this.observableListAllOrders;
    }

    /**
     * metoda odświeża listę produktów po jej edytowaniu( dodaniu lub usunięciu użytkownika)
     */

    public void refresh_products_table(){
        this.observableListAllProducts = FXCollections.observableArrayList();
        tbl_products.getColumns().clear();
        tbl_products.setItems(getObservableListAllProducts());
        tbl_products.getColumns().addAll(column_product, column_count);

        used_products.clear();
        help_list.clear();

        used_products.clear();
        help_list.clear();

        refresh_used_products_table();
    }
    /**
     * metoda odświeża listę produktów użytych po jej edytowaniu( dodaniu lub usunięciu użytkownika)
     */
    public void refresh_used_products_table(){
        observableListUsedProducts.clear();
        observableListUsedProducts.addAll(used_products);
        tbl_used_products.setItems(observableListUsedProducts);
        tbl_used_products.getColumns().clear();
        tbl_used_products.getColumns().addAll(column_used_product, column_used_count);
    }

    /**
     * metoda odświeża listę dań po jej edytowaniu( dodaniu lub usunięciu użytkownika)
     */
    public void refresh_dish_table(){
        this.observableListAllOrders = FXCollections.observableArrayList();
        tbl_dishes.getColumns().clear();
        tbl_dishes.setItems(getObservableListAllOrders());
        tbl_dishes.getColumns().addAll(column_dish, column_status);
    }

    /**
     *
     * @param event, kliknięcie
     *               metoda odpowiedzialna za usunięcie wybranego produktu z listy użytych produktów
     *               metoda odświeża listę użytych produktów
     */
    @FXML
    void btn_delete(ActionEvent event) {
        used_products.remove(tbl_used_products.getSelectionModel().getSelectedIndex());
        refresh_used_products_table();
    }
    /**
     *
     * metoda odpowiedzialna za zmiane statusu zamówienia poprzez wybranie z listy przez użytkownika
     *
     */
    @FXML
    void btn_status(ActionEvent event) {


        for(int i=0; i<used_products.size(); i++){
            productsService.updateProduct(used_products.get(i), help_list.get(i) - used_products.get(i).getProduct_quantity());
        }

        Orders order = new Orders();
        order.setId(tbl_dishes.getSelectionModel().getSelectedItem().getId());
        order.setStatus(choice_status.getSelectionModel().getSelectedItem().toString());
        order.setDate(tbl_dishes.getSelectionModel().getSelectedItem().getDate());
        order.setDish(tbl_dishes.getSelectionModel().getSelectedItem().getDish());
        ordersService.updateProduct(order);

        refresh_products_table();
        refresh_dish_table();
    }
    /**
     *
     * @param event, kliknięcie
     *               metoda odpowiedzialna za wyczyszczenie listy użytych produktów
     *               metoda odświeża listę użytych produktów
     */
    @FXML
    void btn_clear(ActionEvent event) {
        used_products.clear();
        refresh_used_products_table();
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
     * metoda odpowiedzialna za dodanie użytych składników do tabeli wykorzystane produkty
     *
     */
    @FXML
    void choice_product_action(ActionEvent event){

        Inventory product = new Inventory();
        product.setProduct_id(tbl_products.getSelectionModel().getSelectedItem().getProduct_id());
        product.setProduct_name(tbl_products.getSelectionModel().getSelectedItem().getProduct_name());
        product.setProduct_quantity(Integer.parseInt(choice_products.getValue().toString()));
        product.setProduct_price(tbl_products.getSelectionModel().getSelectedItem().getProduct_price());

        help_list.add(tbl_products.getSelectionModel().getSelectedItem().getProduct_quantity());
        used_products.add(product);
        observableListUsedProducts.clear();
        observableListUsedProducts.addAll(used_products);


        column_used_product.setCellValueFactory(new PropertyValueFactory<>("product_name"));                //show data in table used products
        column_used_count.setCellValueFactory(new PropertyValueFactory<>("product_quantity"));
        tbl_used_products.setItems(observableListUsedProducts);
        tbl_used_products.getColumns().clear();
        tbl_used_products.getColumns().addAll(column_used_product, column_used_count);

    }
    /**
     *
     * metoda odpowiedzialna za wyszukiwanie produktów w bazie
     *
     */
    @FXML
    public void onEnter(ActionEvent event){
        List <Inventory> searched_list = productsService.findByNames(text_product.getText());

        observableListSearchedProducts.clear();
        observableListSearchedProducts.addAll(searched_list);

        column_product.setCellValueFactory(new PropertyValueFactory<>("product_name"));                //show data in table used products
        column_count.setCellValueFactory(new PropertyValueFactory<>("product_quantity"));
        tbl_products.setItems(observableListSearchedProducts);
        tbl_products.getColumns().clear();
        tbl_products.getColumns().addAll(column_product, column_count);
    }

    @FXML
    void initialize() {
        tbl_used_products.setPlaceholder(new Label("Brak wykorzystanych produktow"));
        ConfigurableApplicationContext springContext = RestaurantApplication.getSpringContext();
        productsService = (ProductsService) springContext.getBean("productsServiceImpl");
        ordersService = (OrdersService) springContext.getBean("ordersServiceImpl");

        column_product.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        column_count.setCellValueFactory(new PropertyValueFactory<>("product_quantity"));
        tbl_products.setItems(getObservableListAllProducts());
        tbl_products.getColumns().clear();
        tbl_products.getColumns().addAll(column_product, column_count);


        column_dish.setCellValueFactory(new PropertyValueFactory<>("dish"));
        column_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        tbl_dishes.setItems(getObservableListAllOrders());
        tbl_dishes.getColumns().clear();
        tbl_dishes.getColumns().addAll(column_dish, column_status);

        choice_products.setItems(values);
        choice_products.setVisibleRowCount(5);      //visible rows of quantinty combobox

        choice_status.setItems(valuesStatus);


    }


}
