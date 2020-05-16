package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.RestaurantApplication;
import com.l1gr2.restaurant.SceneManager;
import com.l1gr2.restaurant.entity.Users;
import com.l1gr2.restaurant.service.UsersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class ListOfUsersController{

    @FXML
    private TableView<Users> tableViewListOfUsers;

    @FXML
    private TableColumn<Users, String> textFieldFullname;

    @FXML
    private TableColumn<Users, String> textFieldLogin;

    @FXML
    private TableColumn<Users, String> textFieldRole;

    private UsersService usersService;
    ObservableList<Users> observableListAllUsers = FXCollections.observableArrayList();

    @FXML
    void logoutButton(ActionEvent event) {
        SceneManager.renderScene("menuPage");
    }

    @FXML
    void addUserButton(ActionEvent event) {
        SceneManager.renderScene("addUser");
    }

    public ObservableList<Users> getObservableListAllUsers() {
        List<Users> usersList = usersService.getAllUsers();
        this.observableListAllUsers.addAll(usersList);
        return this.observableListAllUsers;
    }

    @FXML
    void deleteUser(ActionEvent event) {
        Users selectedItem = tableViewListOfUsers.getSelectionModel().getSelectedItem();
        usersService.deleteUser(selectedItem);
        refreshTable();
    }

    private void refreshTable() {
        this.observableListAllUsers = FXCollections.observableArrayList();
        tableViewListOfUsers.getColumns().clear();
        tableViewListOfUsers.setItems(getObservableListAllUsers());
        tableViewListOfUsers.getColumns().addAll(textFieldFullname, textFieldLogin, textFieldRole);
    }

    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = RestaurantApplication.getSpringContext();
        usersService = (UsersService) springContext.getBean("usersServiceImpl");

        textFieldFullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        textFieldLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        textFieldRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        tableViewListOfUsers.getColumns().clear();
        tableViewListOfUsers.setItems(getObservableListAllUsers());
        tableViewListOfUsers.getColumns().addAll(textFieldFullname, textFieldLogin, textFieldRole);
    }

}
