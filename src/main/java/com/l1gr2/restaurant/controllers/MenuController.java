package com.l1gr2.restaurant.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Controller;

import java.io.IOException;


@Controller
public class MenuController {

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    void adminGuiButton(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/list-of-users.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListOfUsersController listOfUsersController = fxmlLoader.getController();
        listOfUsersController.setMainController(mainController);
        mainController.setScreen(anchorPane);
    }


    @FXML
    void initialize() {
    }
}
