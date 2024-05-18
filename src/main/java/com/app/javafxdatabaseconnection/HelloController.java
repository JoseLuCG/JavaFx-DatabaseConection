package com.app.javafxdatabaseconnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label welcomeText1;
    @FXML
    private Label welcomeText;

    public void singInController(ActionEvent actionEvent) {
        String email = emailField.getText();
        String newText = email + "Pelele";
        emailField.setText(newText);

    }

    public void newAcountController(ActionEvent actionEvent) {
        System.out.println("adios");

    }
}