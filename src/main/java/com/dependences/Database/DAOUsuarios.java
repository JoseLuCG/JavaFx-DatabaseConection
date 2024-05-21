package com.dependences.Database;

import com.dependences.Models.Rol;
import com.dependences.Models.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.dependences.Database.DataBaseCreator.conn;
import static com.dependences.Database.DataBaseCreator.connection;
import static com.dependences.Tools.Functions.*;

public class DAOUsuarios {
    /**
     * Enter the passed user as a parameter to the database.
     * @param user User to be entered in the database.
     */
    public static void setUsuario (Usuario user) {
        PreparedStatement insertUser = null;

        if (connection()) {
            try {
                String sqlQuery = "INSERT INTO usuarios(email,password,estado,rol) VALUES( ?, ?, ?, ?)";

                insertUser = conn.prepareStatement(sqlQuery);
                insertUser.setString(1, user.getEmail());
                insertUser.setString(2, user.getPassword());
                insertUser.setString(3, user.getState());
                insertUser.setString(4, user.getRol().name());
                insertUser.executeUpdate();
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else outPut.println("La conexión ha fallado.");
    }

    /**
     * Modify the user that corresponds to the established email and password.
     * @param user User to modify.
     * @param newPassword New password for the user.
     */
    public static void updateUsuario (Usuario user, String newPassword) {
        PreparedStatement updateUsuario = null;

        if (connection()) {
            try {
                String sqlQuery = "UPDATE usuarios SET password = ? WHERE email = ? AND password = ?";

                updateUsuario = conn.prepareStatement(sqlQuery);
                updateUsuario.setString(1, newPassword);
                updateUsuario.setString(2, user.getEmail());
                updateUsuario.setString(3, user.getPassword());
                updateUsuario.executeUpdate();
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else outPut.println("La conexión ha fallado.");
    }

    /**
     * Remove the user passed as a parameter.
     * @param user User to delete.
     */
    public static void deleteUser(Usuario user) {
        PreparedStatement deleteUsuario = null;

        if (connection()) {
            try {
                String sqlQuery = "DELETE FROM usuarios WHERE email = ? AND password = ?";

                deleteUsuario = conn.prepareStatement(sqlQuery);
                deleteUsuario.setString(1,user.getEmail());
                deleteUsuario.setString(2,user.getPassword());
                deleteUsuario.executeUpdate();
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else outPut.println("La conexión ha fallado.");
    }

    public static boolean logSQL (Usuario user) {
        PreparedStatement mySqlSelect = null;
        ResultSet mySqlResult = null;

        if (connection()) {
            try {
                String sqlQuery = "SELECT * FROM usuarios WHERE email = ? AND password = ?";

                mySqlSelect = conn.prepareStatement(sqlQuery);
                mySqlSelect.setString(1,user.getEmail());
                mySqlSelect.setString(2,user.getPassword());
                mySqlResult = mySqlSelect.executeQuery();

                if(mySqlResult.next()) return true;
                else return false;
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return false;
            }
        } else {
            outPut.println("La conexión ha fallado.");
            return false;
        }
    }

    public static ArrayList<Usuario> showData () {
        ArrayList<Usuario> userList = new ArrayList<>();
        Statement mysqlSelect = null;
        ResultSet mySqlResult = null;

        if (connection()) {
            try {
                String sqlQuery = "SELECT * FROM usuarios";

                mysqlSelect = conn.createStatement();
                mySqlResult = mysqlSelect.executeQuery(sqlQuery);

                //System.out.println("================================================================");
                //outPut.printf("%15s %15s %15s %15s","Correo","Contraseña","Estado","Rol");
                //System.out.println();
                //System.out.println("================================================================");
                while (mySqlResult.next()) {
                    Usuario user = new Usuario(
                            mySqlResult.getString(1),
                            mySqlResult.getString(2),
                            mySqlResult.getString(3),
                            Rol.valueOf(mySqlResult.getString(4))
                    );
                    //outPut.printf("%15s ",mySqlResult.getString(1));
                    //outPut.printf("%15s ",mySqlResult.getString("password"));
                    //outPut.printf("%15s ",mySqlResult.getString("estado"));
                    //outPut.printf("%15s ",mySqlResult.getString("rol"));
                    //outPut.println();
                }
                //System.out.println("================================================================");
                mySqlResult.close();
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else outPut.println("Error, la conexión ha fallado.");
    }
}
