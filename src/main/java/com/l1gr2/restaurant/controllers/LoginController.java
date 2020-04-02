package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @FXML
    void loginButton(ActionEvent event) {
        SceneManager.renderScene("menuPage");
    }

    @FXML
    void initialize() {
    }
}
