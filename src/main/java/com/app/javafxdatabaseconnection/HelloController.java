package com.app.javafxdatabaseconnection;

import com.dependences.Tools.Views;
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

import static com.dependences.Tools.Functions.*;
import static com.dependences.Tools.Alerts.*;

public class HelloController {
    @FXML
    private Button registro;
    @FXML
    private Button enterButton;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label welcomeText1;
    @FXML
    private Label welcomeText;

    public void singInController(ActionEvent actionEvent) {
        String userEmail = emailField.getText();
        String password = passwordField.getText();
        boolean userIsLogged = login(userEmail, password);

        if ( userIsLogged ) {
            Views.mainView();
            Stage stage = (Stage) enterButton.getScene().getWindow();
            stage.close();
        } else {
            userNotFound();
        }

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
           System.err.println(e.getMessage());
       }


    }
}