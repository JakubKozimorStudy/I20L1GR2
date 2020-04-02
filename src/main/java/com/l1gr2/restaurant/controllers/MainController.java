package com.l1gr2.restaurant.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class MainController {

    @FXML
    private StackPane mainStackPane;

    @FXML
    private void initialize() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/menu-page.fxml"));
        AnchorPane pane = null;
        try {
            pane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStackPane.getChildren().add(pane);
    }
}
