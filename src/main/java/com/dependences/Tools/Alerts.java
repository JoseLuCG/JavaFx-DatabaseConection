package com.dependences.Tools;

import javafx.scene.control.Alert;

public class Alerts {
    public static void userNotFound () {
        Alert userNotFound = new Alert(Alert.AlertType.ERROR);
        userNotFound.setHeaderText("El usuario introducido no se encuentra en la base de datos.");
        userNotFound.showAndWait();
    }
}
