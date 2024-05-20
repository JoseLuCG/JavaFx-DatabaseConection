package com.app.javafxdatabaseconnection;

import com.dependences.Database.DataBaseCreator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 240, 260);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // Crear la base de datos.
        DataBaseCreator.createDatabase();
        // Crear la tabla usuarios.
        DataBaseCreator.createTableUsers();
    }

    public static void main(String[] args) {
        launch();
    }
}