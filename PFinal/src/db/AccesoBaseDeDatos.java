/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * http://theopentutorials.com/tutorials/java/jdbc/jdbc-mysql-create-database-example/
 * @author Super
 */
public class AccesoBaseDeDatos {

    private final String SQL_DRIVER = "com.mysql.jdbc.Driver";

    private static String usuario;
    private static String password;
    private static String db_path;

    private static Connection conexion = null;

    public AccesoBaseDeDatos(String usuario, String password, String db_path) throws ClassNotFoundException, SQLException {
        AccesoBaseDeDatos.usuario = usuario;
        AccesoBaseDeDatos.password = password;
        AccesoBaseDeDatos.db_path = "jdbc:mysql://" + db_path;
      
    }

    private boolean comprobarBaseDatos(String dbName) {

        try {
            Class.forName(SQL_DRIVER); //Register JDBC Driver

            conexion = DriverManager.getConnection(AccesoBaseDeDatos.db_path, AccesoBaseDeDatos.usuario, AccesoBaseDeDatos.password);

            try (ResultSet resultSet = conexion.getMetaData().getCatalogs()) {
                while (resultSet.next()) {

                    String databaseName = resultSet.getString(1);
                    if (databaseName.equals(dbName)) {
                        return true;
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }

        return false;
    }
}
