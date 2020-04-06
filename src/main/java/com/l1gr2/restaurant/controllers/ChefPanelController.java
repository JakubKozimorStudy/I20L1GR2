package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ChefPanelController {

    @FXML
    void logoutButton(ActionEvent event) {
        SceneManager.renderScene("menuPage");
    }

    @FXML
    void initialize() {
    }
}
