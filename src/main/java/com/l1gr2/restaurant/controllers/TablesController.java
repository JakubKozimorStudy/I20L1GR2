package com.l1gr2.restaurant.controllers;

import com.l1gr2.restaurant.SceneManager;
import com.l1gr2.restaurant.tables.Tables;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TablesController {

    @FXML
    void table_1 (ActionEvent event){
        Tables.actualTable = 1;
        SceneManager.renderScene("list_of_dishes");}

    @FXML
    void table_2 (ActionEvent event){
        Tables.actualTable = 2;
        SceneManager.renderScene("list_of_dishes");}

    @FXML
    void table_3 (ActionEvent event){
        Tables.actualTable = 3;
        SceneManager.renderScene("list_of_dishes");}

    @FXML
    void table_4 (ActionEvent event){
        Tables.actualTable = 4;
        SceneManager.renderScene("list_of_dishes");}

    @FXML
    void table_5 (ActionEvent event){
        Tables.actualTable = 5;
        SceneManager.renderScene("list_of_dishes");}

    @FXML
    void table_6 (ActionEvent event){
        Tables.actualTable = 6;
        SceneManager.renderScene("list_of_dishes");}

    @FXML
    void table_7 (ActionEvent event){
        Tables.actualTable = 7;
        SceneManager.renderScene("list_of_dishes");}

    @FXML
    void table_8 (ActionEvent event){
        Tables.actualTable = 8;
        SceneManager.renderScene("list_of_dishes");}

    @FXML
    void table_9 (ActionEvent event){
        Tables.actualTable = 9;
        SceneManager.renderScene("list_of_dishes");}

    @FXML
    void back (ActionEvent event){ SceneManager.renderScene("menuPage");}
}
