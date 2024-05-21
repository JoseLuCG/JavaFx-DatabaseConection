package com.app.javafxdatabaseconnection;

import static com.dependences.Database.DAOUsuarios.*;

import com.dependences.Models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

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
        ArrayList<Usuario> users = datareceiver();

        for (Usuario user: users) {
            System.out.println(user.toString());
        }
    }

    public void AddUser(ActionEvent actionEvent) {
    }

    public void updateUser(ActionEvent actionEvent) {
    }

    public void deleteUser(ActionEvent actionEvent) {
    }
}
