package com.dependences.Database;

import static com.dependences.Tools.Functions.*;

import java.sql.*;

public class DataBaseCreator {
    static Connection conn = null;

    /**
     * Establishes a connection to the database without selecting any existing database.
     * @return True if connected. False if not connected.
     */
    public static boolean firstConnection() {
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/"; //podemos indicar la url "jdbc:mysql://localhost:3306"
        String user = "root";			// usuario
        String pwd = "abc123.";			// contraseña

        try {
            //nos conectamos al servidor, sin conectarnos con una bd en concreto
            conn = DriverManager.getConnection(dbUrl, user, pwd);
            System.out.println("Conexion realizada con exito");

            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Establishes the connection to the database.
     * @return True if connected. False if not connected.
     */
    public static boolean connection() {
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/"; //podemos indicar la url "jdbc:mysql://localhost:3306"
        String db = "controlusuarios";	// nombre de la base de datos;
        String user = "root";			// usuario
        String pwd = "abc123.";			// contraseña

        try {
            //nos conectamos al servidor, sin conectarnos con una bd en concreto
            conn = DriverManager.getConnection(dbUrl, user, pwd);
            conn.setCatalog(db);
            System.out.println("Conexion realizada con exito");

            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * If it does not exist, creates the usercontrol database.
     */
    public static void createDatabase() {
        Statement dbCreation = null;

        if (firstConnection()) {
            try {
                String sqlQuery = "Create schema if not exists controlusuarios default char set utf8mb4 default collate utf8mb4_spanish_ci";
                dbCreation = conn.createStatement();
                dbCreation.executeUpdate(sqlQuery);
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Creates usuarios table.
     */
    public static void createTableUsers () {
        Statement createTable = null;

        if (connection()) {
            try {
                String sqlQuery = "CREATE TABLE IF NOT EXISTS usuarios (" +
                        "email VARCHAR(50) NOT NULL, " +
                        "password VARCHAR(50) NOT NULL, " +
                        "estado VARCHAR(10), " +
                        "rol VARCHAR(50), " +
                        "CONSTRAINT pk_usuarios PRIMARY KEY(email) ) ";

                createTable = conn.createStatement();
                createTable.executeUpdate(sqlQuery);
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        } else outPut.println("La conexión ha fallado.");
    }
}
