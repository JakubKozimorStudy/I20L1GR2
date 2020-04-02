package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ListOfUsersController {

    @FXML
    void logoutButton(ActionEvent event) {
        SceneManager.renderScene("menuPage");
    }

    @FXML
    void addUserButton(ActionEvent event) {
        SceneManager.renderScene("addUser");
    }

    @FXML
    void editUserButton(ActionEvent event) {
        SceneManager.renderScene("addUser");
    }

    @FXML
    void initialize() {
    }

}
