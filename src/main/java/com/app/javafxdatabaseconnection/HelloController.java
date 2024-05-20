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

import static com.dependences.Tools.Functions.*;

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
        boolean userExists = true;

        if (userExists) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
                Parent mainRoot = fxmlLoader.load();
                Stage mainStage = new Stage();
                mainStage.setTitle("Ventana Principal");
                mainStage.setScene(new Scene(mainRoot,400,400));
                mainStage.show();

                Stage stage = (Stage) enterButton.getScene().getWindow();
                stage.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            //defaultfunction();
            outPut.println("El usuario introducido es incorrecto.");
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