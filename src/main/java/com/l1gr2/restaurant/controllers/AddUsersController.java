package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.RestaurantApplication;
import com.l1gr2.restaurant.SceneManager;
import com.l1gr2.restaurant.entity.Users;
import com.l1gr2.restaurant.service.UsersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class AddUsersController {

    private UsersService usersService;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField repeatedPassword;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private Label emptyFilesMessage;

    @FXML
    private Label notTheSamePasswordMessage;

    @FXML
    private Label successMessage;

    ObservableList<String> roles = FXCollections.observableArrayList("Kelner", "Manager", "Kucharz", "Administrator");

    @FXML
    void backToUserListButton(ActionEvent event) {
        SceneManager.renderScene("listOfUsers");
    }


    @FXML
    void addNewUser(ActionEvent event) {
        notTheSamePasswordMessage.setText("");
        emptyFilesMessage.setText("");
        Users newUser = new Users();
        if (checkFields() && checkUniqueness()) {
            successMessage.setText("Dodano użytkownika");
            successMessage.setStyle("-fx-text-fill: green;");
            assignValuesToNewUser(newUser);
            usersService.addUser(newUser);
        }
    }

    private boolean checkUniqueness() {
        if (usersService.checkUniqueness(login.getText())) {
            emptyFilesMessage.setText("Uzytkownik z takim loginem już istnieje");
            emptyFilesMessage.setStyle("-fx-text-fill: red;");
            return false;
        }
        return true;
    }

    private boolean checkFields() {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || login.getText().isEmpty() ||
                password.getText().isEmpty() || roleComboBox.getValue() == null) {
            emptyFilesMessage.setText("Pola nie mogą być puste");
            emptyFilesMessage.setStyle("-fx-text-fill: red;");
            return false;
        } else {
            if (password.getText().equals(repeatedPassword.getText())) {
                return true;
            } else {
                notTheSamePasswordMessage.setText("Hasła muszą być identyczne");
                notTheSamePasswordMessage.setStyle("-fx-text-fill: red;");;
                return false;
            }
        }
    }

    private void assignValuesToNewUser(Users newUser) {
        newUser.setFirstName(firstName.getText());
        newUser.setLastName(lastName.getText());
        newUser.setLogin(login.getText());
        newUser.setPassword(password.getText());
        newUser.setRole(roleComboBox.getValue());
    }

    @FXML
    private void initialize() {
        ConfigurableApplicationContext springContext = RestaurantApplication.getSpringContext();
        usersService = (UsersService) springContext.getBean("usersServiceImpl");

        roleComboBox.setItems(roles);
    }
}
