package com.app.javafxdatabaseconnection;

import com.dependences.Models.Rol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.dependences.Tools.Functions.*;

public class RegisterViewController implements Initializable {
    @FXML
    private Button registro;
    @FXML
    private Button resertButton;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField stateField;
    @FXML
    private ChoiceBox<Rol> rolField = new ChoiceBox<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rolField.getItems().addAll(Rol.values());
    }

    public void singUpAction(ActionEvent actionEvent) {
        String emailUser = emailField.getText();
        String passwordUser = passwordField.getText();
        String userState = stateField.getText();
        Rol userRol = rolField.getValue();

        insertUser(emailUser,passwordUser,userState,userRol);

    }

    public void resetAction(ActionEvent actionEvent) {
        emailField.setText("");
        passwordField.setText("");
        stateField.setText("");
        rolField.setValue(Rol.INVITADO);
    }
}
