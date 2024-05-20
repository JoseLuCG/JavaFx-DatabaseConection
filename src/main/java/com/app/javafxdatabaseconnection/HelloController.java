package com.app.javafxdatabaseconnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public Button registro;
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

    public void newAcountController() {
       try {
           FXMLLoader Loader = new FXMLLoader(getClass().getResource("register-view.fxml"));
           Parent root= Loader.load();
           Stage nuevaVentana=new Stage();
           nuevaVentana.setTitle("Hello!");
           nuevaVentana.setScene(new Scene(root, 300, 400));
           nuevaVentana.show();

           Stage stage=(Stage) registro.getScene().getWindow();
           stage.close();
       }catch (IOException e){
           System.out.println(e.getMessage());
       }


    }
}