package com.dependences.Tools;

import com.app.javafxdatabaseconnection.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Views {

    public static void mainView () {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
            Parent mainRoot = fxmlLoader.load();
            Stage mainStage = new Stage();
            mainStage.setTitle("Ventana Principal");
            mainStage.setScene(new Scene(mainRoot,1500,900));
            mainStage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
