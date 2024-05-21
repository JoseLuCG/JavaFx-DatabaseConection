package com.app.javafxdatabaseconnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML
    private TableView usersTable;
    @FXML
    private TableColumn tableEmailField;
    @FXML
    private TableColumn tablePasswordField;
    @FXML
    private TableColumn tableStateField;
    @FXML
    private TableColumn tableRolField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField stateField;
    @FXML
    private ChoiceBox rolField;
    @FXML
    private Button addUserButton;
    @FXML
    private Button updateUserButton;
    @FXML
    private Button deleteUSerButton;
    @FXML
    private Button loadUsersButton;

    public void loadData(ActionEvent actionEvent) {
        System.out.println("works");
    }

    public void AddUser(ActionEvent actionEvent) {
    }

    public void updateUser(ActionEvent actionEvent) {
    }

    public void deleteUser(ActionEvent actionEvent) {
    }
}
