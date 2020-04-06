package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class MenuPageController {

    @FXML
    void logoutButton(ActionEvent event) {
        SceneManager.renderScene("loginPage");
    }

    @FXML
    void adminPageButton(ActionEvent actionEvent) {
        SceneManager.renderScene("listOfUsers");
    }

    @FXML
    void menagerPageButton(ActionEvent actionEvent) {
        SceneManager.renderScene("ManagerPanel");
    }

    @FXML
    void chefPageButton(ActionEvent actionEvent) {
        SceneManager.renderScene("chefPanel");
    }

    @FXML
    void initialize() {
    }
}
