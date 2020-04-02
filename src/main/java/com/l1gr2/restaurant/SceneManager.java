package com.l1gr2.restaurant;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Hashtable;

public class SceneManager {
    private static Stage stage;
    private static Hashtable<String, String> view = new Hashtable<>();

    public static void addScene(String name, String path) {
        view.put(name, path);
    }

    public static void removeScene(String name) {
        view.remove(name);
    }

    public static void renderScene(String name) {
        String path = "";

        try {
            path = view.get(name);
            Parent root = FXMLLoader.load(SceneManager.class.getClassLoader().getResource(path));
            Scene scene = new Scene(root,800,600);
            stage.setTitle("Restauracja");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Nie udalo sie załadowsć scieżki:" + path);
        } catch (RuntimeException ex) {
            System.err.println("drugi wyjątek");
            ex.printStackTrace();
        }
    }
    public static void setStage(Stage _stage) {
        stage = _stage;
    }
}
