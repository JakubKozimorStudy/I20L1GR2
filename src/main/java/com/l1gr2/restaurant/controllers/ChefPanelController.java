package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.RestaurantApplication;
import com.l1gr2.restaurant.SceneManager;
import com.l1gr2.restaurant.entity.Dish;
import com.l1gr2.restaurant.entity.Orders;
import com.l1gr2.restaurant.entity.Products;
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

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ChefPanelController {


    @FXML
    private TableView<Products> tbl_products;

    @FXML
    private TableColumn<Products, String> column_product;

    @FXML
    private TableColumn<Products, String> column_count;

    @FXML
    private TableView<Products> tbl_used_products;

    @FXML
    private TableColumn<Products, String> column_used_product;

    @FXML
    private TableColumn<Products, String> column_used_count;

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

    List<Products> used_products = new ArrayList<Products>();
    List<Integer> help_list = new ArrayList<Integer>();


    private ProductsService productsService;
    private OrdersService ordersService;

    ObservableList<Products> observableListAllProducts = FXCollections.observableArrayList();
    ObservableList<Products> observableListUsedProducts = FXCollections.observableArrayList();
    ObservableList<Products> observableListSearchedProducts = FXCollections.observableArrayList();

    ObservableList<Orders> observableListAllOrders = FXCollections.observableArrayList();
    ObservableList<Integer> values = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30);
    ObservableList<String> valuesStatus = FXCollections.observableArrayList("W realizacji", "Gotowe", "Odrzucono");

    public ObservableList<Products> getObservableListAllProducts() {
        List<Products> productsList = productsService.getAllProducts();
        this.observableListAllProducts.addAll(productsList);
        return this.observableListAllProducts;
    }

    public ObservableList<Orders> getObservableListAllOrders(){
        List<Orders> ordersList = ordersService.getAllOrders();
        this.observableListAllOrders.addAll(ordersList);
        return this.observableListAllOrders;
    }



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

    public void refresh_used_products_table(){
        observableListUsedProducts.clear();
        observableListUsedProducts.addAll(used_products);
        tbl_used_products.setItems(observableListUsedProducts);
        tbl_used_products.getColumns().clear();
        tbl_used_products.getColumns().addAll(column_used_product, column_used_count);
    }


    public void refresh_dish_table(){
        this.observableListAllOrders = FXCollections.observableArrayList();
        tbl_dishes.getColumns().clear();
        tbl_dishes.setItems(getObservableListAllOrders());
        tbl_dishes.getColumns().addAll(column_dish, column_status);
    }
    @FXML
    void btn_delete(ActionEvent event) {
        used_products.remove(tbl_used_products.getSelectionModel().getSelectedIndex());
        refresh_used_products_table();
    }

    @FXML
    void btn_status(ActionEvent event) {


        for(int i=0; i<used_products.size(); i++){
            productsService.updateProduct(used_products.get(i), help_list.get(i) - used_products.get(i).getQuantity());
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

    @FXML
    void btn_clear(ActionEvent event) {
        used_products.clear();
        refresh_used_products_table();
    }

    @FXML
    void logoutButton(ActionEvent event) {
        SceneManager.renderScene("menuPage");
    }

    @FXML
    void choice_product_action(ActionEvent event){

        Products product = new Products();
        product.setId(tbl_products.getSelectionModel().getSelectedItem().getId());
        product.setName(tbl_products.getSelectionModel().getSelectedItem().getName());
        product.setQuantity(Integer.parseInt(choice_products.getValue().toString()));
        product.setUnit(tbl_products.getSelectionModel().getSelectedItem().getUnit());

        help_list.add(tbl_products.getSelectionModel().getSelectedItem().getQuantity());
        used_products.add(product);
        observableListUsedProducts.clear();
        observableListUsedProducts.addAll(used_products);


        column_used_product.setCellValueFactory(new PropertyValueFactory<>("name"));                //show data in table used products
        column_used_count.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tbl_used_products.setItems(observableListUsedProducts);
        tbl_used_products.getColumns().clear();
        tbl_used_products.getColumns().addAll(column_used_product, column_used_count);

    }

    @FXML
    public void onEnter(ActionEvent event){
        List <Products> searched_list = productsService.findByNames(text_product.getText());

        observableListSearchedProducts.clear();
        observableListSearchedProducts.addAll(searched_list);

        column_product.setCellValueFactory(new PropertyValueFactory<>("name"));                //show data in table used products
        column_count.setCellValueFactory(new PropertyValueFactory<>("quantity"));
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

        column_product.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_count.setCellValueFactory(new PropertyValueFactory<>("quantity"));
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
