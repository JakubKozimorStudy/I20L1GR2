package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ManagerPanelController {

    @FXML
    void logoutButton(ActionEvent event) {
        SceneManager.renderScene("menuPage");
    }

    @FXML
    void ListOfKelnersButton(ActionEvent event) { SceneManager.renderScene("listOfUsers");}

    @FXML
    void initialize() {
    }
}
