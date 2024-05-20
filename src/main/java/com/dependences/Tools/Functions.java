package com.dependences.Tools;

import com.dependences.Models.Rol;
import com.dependences.Models.Usuario;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static com.dependences.Database.DAOUsuarios.*;

public class Functions {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    public static Scanner sc = new Scanner(System.in);

    /**
     * Insert a user in database.
     */
    public static void insertUser() {
        Usuario newUser;
        String email, password, state;
        Rol rolType = Rol.INVITADO; // ADMIN, INVITADO, USUARIO
        int rolOption;

        outPut.println("Introduzca el correo del nuevo usuario:");
        email = sc.nextLine();
        outPut.println("Introduzca la contraseña del nuevo usuario:");
        password = sc.nextLine();
        outPut.println("Introduzca el estado del usuario:");
        state = sc.nextLine();
        do {
            outPut.println("Introduzca el rol del usuario:");
            outPut.println("[1] - Administrador");
            outPut.println("[2] - Usuario");
            outPut.println("[3] - Invitado");
            rolOption = sc.nextInt();
            sc.nextLine();
            switch (rolOption) {
                case 1: rolType = Rol.ADMIN; break;
                case 2: rolType = Rol.USUARIO; break;
                case 3: rolType = Rol.INVITADO; break;
                default: outPut.println("Seleccione una opción válida.");
            }
        } while (rolOption != 1 && rolOption != 2 && rolOption != 3);

        newUser = new Usuario(email,password,state,rolType);
        setUsuario(newUser);
    }

    /**
     * Update the password for the selected user.
     */
    public static void updatePassword(){
        Usuario newUser;
        String email, password, newPassword;

        outPut.println("Introduzca el email:");
        email = sc.nextLine();
        outPut.println("Introduzca la contraseña:");
        password = sc.nextLine();
        outPut.println("Escriba la nueva contraseña:");
        newPassword = sc.nextLine();

        newUser = new Usuario(email, password);

        if (password.equals(newPassword)) {
            do {
                outPut.println("La nueva contraseña no puede ser igual a la anterior.");
                outPut.println("Escriba una nueva contraseña:");
                newPassword = sc.nextLine();
            } while (newPassword.equals(password));
            updateUsuario( newUser, newPassword );
        } else updateUsuario( newUser, newPassword );
    }

    /**
     * Deletes a user in the database.
     */
    public static void delUser() {
        String email, password;
        Usuario delUser;

        outPut.println("Indique el email del usuario a eliminar:");
        email = sc.nextLine();
        outPut.println("Indique la contraseña del usuario a eliminar:");
        password = sc.nextLine();

        delUser = new Usuario(email, password);
        deleteUser(delUser);
    }

    public static void login() {
        String email, password;
        Usuario logUser;

        outPut.println("Introduzca el email:");
        email = sc.nextLine();
        outPut.println("Introduzca la contraseña:");
        password = sc.nextLine();

        logUser = new Usuario(email, password);
        logSQL(logUser);
    }
}
