package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.RestaurantApplication;
import com.l1gr2.restaurant.SceneManager;

import com.l1gr2.restaurant.entity.Users;
import com.l1gr2.restaurant.service.UsersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;

import java.util.List;

@Controller
public class LoginController {

    UsersService usersService;

    @FXML
    private TextField textfield_login_name;



    @FXML
    private PasswordField text_field_password;
    @FXML

    void loginButton(ActionEvent event) {
        String nick = textfield_login_name.getText();
        String password = text_field_password.getText();

        String role = usersService.findUserAndGetRole(nick, password);






        if(!role.isEmpty())
            {
                if(role.equals("Kelner")){
                    SceneManager.renderScene("tables-page");
                }
                if(role.equals("Administrator")){
                    SceneManager.renderScene("listOfUsers");
                }
                if(role.equals("Menadżer")){
                    SceneManager.renderScene("ManagerPanel");
                }
                if(role.equals("Kucharz")){
                    SceneManager.renderScene("chefPanel");
                }
            }
        else
            {
                Alert error=new Alert(Alert.AlertType.ERROR);
                error.setContentText("Wprowadzone dane są nieprawidłowe");
                error.setTitle("Błąd danych");
                error.setHeaderText("Błąd autoryzacji");
                error.show();
            }



    }

    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = RestaurantApplication.getSpringContext();
        usersService = (UsersService) springContext.getBean("usersServiceImpl");
    }
}
