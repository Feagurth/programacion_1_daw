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

/**
 *
 * @author Super
 */
class DBAccess {

    private final String SQL_DRIVER = "com.mysql.jdbc.Driver";

    private static String usuario;
    private static String password;
    private static String db_path;
    private static String database;
    private Statement instruccion;

    private static Connection conexion = null;

    protected DBAccess(String usuario, String password, String db_path, String database) throws ClassNotFoundException, SQLException {
        DBAccess.usuario = usuario;
        DBAccess.password = password;
        DBAccess.db_path = "jdbc:mysql://" + db_path;
        DBAccess.database = database;

        if (!checkDB()) {

            createDB();
        }

        DBAccess.conexion = DriverManager.getConnection(DBAccess.db_path + "/" + DBAccess.database, DBAccess.usuario, DBAccess.password);
    }

    private boolean checkDB() throws ClassNotFoundException, SQLException {

        Class.forName(SQL_DRIVER); //Register JDBC Driver

        conexion = DriverManager.getConnection(DBAccess.db_path, DBAccess.usuario, DBAccess.password);

        try (ResultSet resultSet = conexion.getMetaData().getCatalogs()) {
            while (resultSet.next()) {

                String databaseName = resultSet.getString(1);
                if (databaseName.equals(DBAccess.database)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int createDB() throws SQLException {
        int resultado = 0;

        String[] sql = {"DROP DATABASE IF EXISTS libros;",
            "CREATE DATABASE libros;",
            "USE libros;",
            "CREATE TABLE autores(idAutor int NOT NULL AUTO_INCREMENT PRIMARY KEY, primerNombre varchar(30) NOT NULL, apellidoPaterno varchar(30) NOT NULL);",
            "CREATE TABLE titulos(isbn varchar(20) NOT NULL PRIMARY KEY, titulo varchar(100) NOT NULL, numeroEdicion int NOT NULL, editorial varchar(50) NOT NULL, copyright varchar(4) NOT NULL);",
            "CREATE TABLE isbnAutor(idAutor int NOT NULL, isbn varchar(20) NOT NULL, FOREIGN KEY (idAutor) REFERENCES autores(idAutor), FOREIGN KEY (isbn) References titulos(isbn));",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('Harvey','Deitel');",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('Paul','Deitel');",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('Andrew','Goldberg');",
            "INSERT INTO autores (primerNombre,apellidoPaterno) VALUES ('David','Choffnes');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright) VALUES ('0131869000','Visual Basic 2005 How to Program',3, 'Minotauro', '2006');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131869000');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131869000');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright) VALUES ('0131525239','Visual C# 2005 How to Program',2,'Minotauro', '2006');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131525239');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131525239');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright) VALUES ('0132222205','Java How to Program',7,'Minotauro', '2007');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0132222205');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0132222205');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright) VALUES ('0131857576','C++ How to Program',5,'Minotauro', '2005');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131857576');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131857576');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright) VALUES ('0132404168','C How to Program',5,'Alfaguara', '2007');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0132404168');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0132404168');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright) VALUES ('0131450913','Internet & World Wide Web How to Program',3,'Alfaguara', '2004');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131450913');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131450913');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (3,'0131450913');",
            "INSERT INTO titulos (isbn,titulo,numeroEdicion, editorial, copyright) VALUES ('0131828274','Operating Systems',3,'Alfaguara', '2004');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (1,'0131828274');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (2,'0131828274');",
            "INSERT INTO isbnAutor (idAutor,isbn) VALUES (4,'0131828274');"};

        for (String cadena : sql) {
            try {
                instruccion = DBAccess.conexion.createStatement();
                resultado = instruccion.executeUpdate(cadena);
            } catch (SQLException e) {
                resultado = 0;
                throw e;
            } finally {
                instruccion.close();
            }
        }

        return resultado;

    }

    protected int update(String sql) throws SQLException {
        int salida;

        try {
            instruccion = DBAccess.conexion.createStatement();
            salida = instruccion.executeUpdate(sql);
        } catch (SQLException e) {
            salida = 0;
            throw e;
        } finally {
            instruccion.close();
        }

        return salida;
    }

    protected ResultSet query(String sql) throws SQLException {

        ResultSet salida;

        try {
            instruccion = DBAccess.conexion.createStatement();
            salida = instruccion.executeQuery(sql);
        } catch (SQLException e) {
            salida = null;
            throw e;
        } finally {
            instruccion.close();
        }

        return salida;

    }

}
