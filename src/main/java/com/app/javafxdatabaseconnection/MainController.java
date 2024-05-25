package com.app.javafxdatabaseconnection;

import static com.dependences.Database.DAOUsuarios.*;
import static com.dependences.Tools.Functions.*;

import com.dependences.Models.Rol;
import com.dependences.Models.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class MainController {
    @FXML
    private TableView<Usuario> usersTable;
    @FXML
    public TableColumn<Usuario, String> tableEmailField;
    @FXML
    public TableColumn<Usuario, String> tablePasswordField;
    @FXML
    public TableColumn<Usuario, String> tableStateField;
    @FXML
    public TableColumn<Usuario, Rol> tableRolField;
    @FXML
    public TextField emailField;
    @FXML
    public TextField passwordField;
    @FXML
    public TextField stateField;
    @FXML
    private TextField newPasswordField;
    @FXML
    private ChoiceBox<Rol> rolField = new ChoiceBox<>();
    @FXML
    private Button addUserButton;
    @FXML
    private Button updateUserButton;
    @FXML
    private Button deleteUSerButton;
    @FXML
    private Button loadUsersButton;
    ObservableList<Usuario> usuariosList = FXCollections.observableArrayList();
    @FXML
    public void initialize () {
        rolField.getItems().addAll(Rol.values());
        // Configure table fields.
        tableEmailField.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tablePasswordField.setCellValueFactory(new PropertyValueFactory<>("Password"));
        tableStateField.setCellValueFactory(new PropertyValueFactory<>("State"));
        tableRolField.setCellValueFactory(new PropertyValueFactory<>("Rol"));
    }

    public void loadData(ActionEvent actionEvent) {
        ArrayList<Usuario> usuarios = datareceiver();

        usuariosList.setAll(usuarios);
        usersTable.setItems(usuariosList);
    }

    public void AddUser(ActionEvent actionEvent) {
        String emailUser = emailField.getText();
        String password = passwordField.getText();
        String state = stateField.getText();
        Rol rol = rolField.getValue();

        insertUser(emailUser,password,state, rol);
    }

    public void updateUser(ActionEvent actionEvent) {
        String emailUser = emailField.getText();
        String passwordUser = passwordField.getText();
        String newPassword = newPasswordField.getText();

        updatePassword(emailUser, passwordUser, newPassword);
    }

    public void deleteUser(ActionEvent actionEvent) {
        String emailUser = emailField.getText();
        String passwordUser = passwordField.getText();

        delUser(emailUser, passwordUser);
    }
}
