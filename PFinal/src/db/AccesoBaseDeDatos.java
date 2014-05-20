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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Super
 */
public class AccesoBaseDeDatos {

    private final String SQL_DRIVER = "com.mysql.jdbc.Driver";

    private static String usuario;
    private static String password;
    private static String db_path;
    private static String database;

    private static Connection conexion = null;

    public AccesoBaseDeDatos(String usuario, String password, String db_path, String database) throws ClassNotFoundException, SQLException {
        AccesoBaseDeDatos.usuario = usuario;
        AccesoBaseDeDatos.password = password;
        AccesoBaseDeDatos.db_path = "jdbc:mysql://" + db_path;
        AccesoBaseDeDatos.database = database;

        if (!comprobarBaseDatos()) {

            crearBaseDatos();

            AccesoBaseDeDatos.conexion = DriverManager.getConnection(AccesoBaseDeDatos.db_path + "/" + AccesoBaseDeDatos.database, AccesoBaseDeDatos.usuario, AccesoBaseDeDatos.password);
        }
    }

    private boolean comprobarBaseDatos() throws ClassNotFoundException, SQLException {

        Class.forName(SQL_DRIVER); //Register JDBC Driver

        conexion = DriverManager.getConnection(AccesoBaseDeDatos.db_path, AccesoBaseDeDatos.usuario, AccesoBaseDeDatos.password);

        try (ResultSet resultSet = conexion.getMetaData().getCatalogs()) {
            while (resultSet.next()) {

                String databaseName = resultSet.getString(1);
                if (databaseName.equals(AccesoBaseDeDatos.database)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int crearBaseDatos() throws SQLException {
        int resultado = 0;

        String[] sql = {"DROP DATABASE IF EXISTS libros;",
            "CREATE DATABASE libros;",
            "USE libros;",
            "CREATE TABLE autores(idAutor int NOT NULL AUTO_INCREMENT PRIMARY KEY, primerNombre varchar(30) NOT NULL, apellidoPaterno varchar(30) NOT NULL);",
            "CREATE TABLE titulos(isbn varchar(20) NOT NULL PRIMARY KEY, titulo varchar(100) NOT NULL, numeroEdicion int NOT NULL, copyright varchar(4) NOT NULL);",
            "CREATE TABLE isbnAutor(idAutor int NOT NULL, isbn varchar(20) NOT NULL, FOREIGN KEY (idAutor) REFERENCES autores(idAutor), FOREIGN KEY (isbn) References titulos(isbn));",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('Harvey','Deitel');",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('Paul','Deitel');",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('Andrew','Goldberg');",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('David','Choffnes');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion,copyright) VALUES ('0131869000','Visual Basic 2005 How to Program',3,'2006');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131869000');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131869000');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion,copyright) VALUES ('0131525239','Visual C# 2005 How to Program',2,'2006');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131525239');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131525239');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion,copyright) VALUES ('0132222205','Java How to Program',7,'2007');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0132222205');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0132222205');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion,copyright) VALUES ('0131857576','C++ How to Program',5,'2005');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131857576');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131857576');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion,copyright) VALUES ('0132404168','C How to Program',5,'2007');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0132404168');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0132404168');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion,copyright) VALUES ('0131450913','Internet & World Wide Web How to Program',3,'2004');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131450913');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131450913');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (3,'0131450913');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion,copyright) VALUES ('0131828274','Operating Systems',3,'2004');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131828274');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131828274');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (4,'0131828274');"};

        for (String cadena : sql) {
            try (Statement instruccion = AccesoBaseDeDatos.conexion.createStatement()) {
                resultado = instruccion.executeUpdate(cadena);
            }
        }

        return resultado;

    }

    public int actualizar(String sql) throws SQLException {
        Statement instruccion = AccesoBaseDeDatos.conexion.createStatement();

        return instruccion.executeUpdate(sql);
    }

    public ResultSet consultar(String sql) throws SQLException {

        Statement instruccion = AccesoBaseDeDatos.conexion.createStatement();
        return instruccion.executeQuery(sql);

    }

}
