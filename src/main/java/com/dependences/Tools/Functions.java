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
    public static void insertUser(String email, String password, String state, Rol rolType) {
        Usuario newUser;

        newUser = new Usuario(email,password,state,rolType);
        setUsuario(newUser);
    }

    /**
     * Update the password for the selected user.
     */
    public static void updatePassword(String email, String password, String newPassword){
        Usuario newUser;

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

    public static boolean login(String email, String password) {
        Usuario logUser;
        boolean successfulLogin;

        logUser = new Usuario(email, password);
        successfulLogin = logSQL(logUser);

        return successfulLogin;
    }
}
