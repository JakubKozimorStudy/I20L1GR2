package com.l1gr2.restaurant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestaurantApplication extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent rootNode;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(RestaurantApplication.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        SceneManager.setStage(primaryStage);
        SceneManager.addScene("listOfUsers", "fxml/list-of-users.fxml");
        SceneManager.addScene("addUser", "fxml/add-users.fxml");
        SceneManager.addScene("loginPage","fxml/login-panel.fxml");
        SceneManager.addScene("menuPage","fxml/menu-page.fxml");
        SceneManager.addScene("ManagerPanel", "fxml/manager-panel.fxml");
        SceneManager.renderScene("loginPage");
    }

    @Override
    public void stop() {
        springContext.close();
    }
}