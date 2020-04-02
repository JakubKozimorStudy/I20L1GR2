package com.l1gr2.restaurant.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ListOfUsersController {

    private MainController mainController;


    @FXML
    void logoutButton(ActionEvent event) {
        mainController.loadMenuScreen();
    }

    @FXML
    void initialize() {
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
