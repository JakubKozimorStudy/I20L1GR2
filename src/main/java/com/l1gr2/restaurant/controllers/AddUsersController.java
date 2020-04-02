package com.l1gr2.restaurant.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.stereotype.Controller;

@Controller
public class AddUsersController {

    @FXML
    private ComboBox<String> roleComboBox;

    ObservableList<String> roles = FXCollections.observableArrayList("Kelner", "Manager", "Kucharz", "Administrator");

    @FXML
    private void initialize() {
        roleComboBox.setItems(roles);
    }
}
