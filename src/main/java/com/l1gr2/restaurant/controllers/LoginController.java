package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
@Controller
public class LoginController {

    @FXML
    private TextField textfield_login_name;



    @FXML
    private PasswordField text_field_password;
    @FXML
    void loginButton(ActionEvent event) {
        String nick="admin";
        String password="admin";

        String nick_user=textfield_login_name.getText(); //przypisanie z textfielda nick'u wprowadzonego przez usera
        String passwrod_user=text_field_password.getText(); //przypisanie z textfielda hasła wprowadzonego przez usera
        if(nick.equals(nick_user) && password.equals(passwrod_user))
            {
                SceneManager.renderScene("menuPage");
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
    }
}
