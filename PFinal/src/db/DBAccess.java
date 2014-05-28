/*
 * Copyright (C) 2014 Luis Cabrerizo Gómez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase para acceder a la base de datos usando las librerias jdbc
 *
 * @author Luis Cabrerizo Gómez
 */
class DBAccess {

    // Constante con el nombre del driver
    private final String SQL_DRIVER = "com.mysql.jdbc.Driver";

    // Variables y objetos globales
    private static String usuario;
    private static String password;
    private static String db_path;
    private static String database;

    private static Connection conexion = null;
    private Statement instruccion;

    /**
     * Constructor de la clase DBAccess
     *
     * @param usuario Usuario de acceso a la base de datos
     * @param password Password del usuario en la base de datos
     * @param db_path Ruta de la base de datos
     * @param database Nombre de la base de datos a la que acceder
     * @throws ClassNotFoundException Lanza excepción si se produce un error al
     * referenciar el driver JDBC
     * @throws SQLException Lanza excepción si se produce un error en una
     * consulta SQL
     */
    protected DBAccess(String usuario, String password, String db_path, String database) throws ClassNotFoundException, SQLException {

        // Asginamos los parámetros de la función como valores de instancia
        DBAccess.usuario = usuario;
        DBAccess.password = password;
        DBAccess.db_path = "jdbc:mysql://" + db_path;
        DBAccess.database = database;

        // Comprobamos si la base de datos existe
        if (!checkDB()) {

            // Si no existe, la creamos completamente
            createDB();
        }

        // Creamos una conexión a partir de los pasados al método
        DBAccess.conexion = DriverManager.getConnection(DBAccess.db_path + "/" + DBAccess.database, DBAccess.usuario, DBAccess.password);
    }

    /**
     * Clase que comprueba si existe una base de datos
     *
     * @return Verdadero si la base de datos existe, falso si no es así
     * @throws ClassNotFoundException Lanza excepción si se produce un error al
     * referenciar el driver JDBC
     * @throws SQLException Lanza excepción si se produce un error en una
     * consulta SQL
     */
    private boolean checkDB() throws ClassNotFoundException, SQLException {

        // Registramos  el driver JDBC
        Class.forName(SQL_DRIVER);

        // Creamos una conexión a la base de datos ocn los valores que tenemos
        // las variables de instancia
        conexion = DriverManager.getConnection(DBAccess.db_path, DBAccess.usuario, DBAccess.password);

        // Recuperamos los catalogos disponibles en la base de datos, esto es,
        // las bases de datos que tiene
        try (ResultSet resultSet = conexion.getMetaData().getCatalogs()) {

            // Iteramos por el resultado
            while (resultSet.next()) {

                // Recuperamos el nombre de la base de datos
                String databaseName = resultSet.getString(1);

                // Lo comparamos con el nombre de nuestra base de datos                
                if (databaseName.equals(DBAccess.database)) {

                    // Si son iguales, cerramos la conexión y devolvemos verdadero
                    conexion.close();

                    return true;
                }
            }
        }

        // Si no hemos encontrado la base de datos cerramos la conexión y
        // devolvemos falso
        conexion.close();

        return false;
    }

    /**
     * Método para crear una base de datos específica mediante comandos SQL
     *
     * @return 0 si ha habido un error y otro entero en caso contrario
     * @throws SQLException Si se produce un error de SQL
     */
    private int createDB() throws SQLException {

        // Iniciamos la variable de salida
        int resultado = 0;

        // Creamos un array de cadenas con las sentencias que se van a ajecutar
        String[] sql = {"DROP DATABASE IF EXISTS libros;",
            "CREATE DATABASE libros;",
            "USE libros;",
            "CREATE TABLE autores(idAutor int NOT NULL AUTO_INCREMENT PRIMARY KEY, primerNombre varchar(30) NOT NULL, apellidoPaterno varchar(30) NOT NULL);",
            "CREATE TABLE titulos(isbn varchar(20) NOT NULL PRIMARY KEY, titulo varchar(100) NOT NULL, numeroEdicion int NOT NULL, editorial varchar(50) NOT NULL, copyright varchar(4) NOT NULL);",
            "CREATE TABLE isbnAutor(idAutor int NOT NULL, isbn varchar(20) NOT NULL, FOREIGN KEY (idAutor) REFERENCES autores(idAutor) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (isbn) References titulos(isbn) ON DELETE CASCADE ON UPDATE CASCADE);",
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

        // Iteramos por el array de sentecias
        for (String cadena : sql) {
            try {
                // Creamos una instrucción
                instruccion = DBAccess.conexion.createStatement();

                // Y la ejecutamos guardando el resultado
                resultado = instruccion.executeUpdate(cadena);
            } catch (SQLException e) {

                // Si se produce una excepción, reseteamos el resultado y lanzamos
                // una excepción
                resultado = 0;
                throw e;
            } finally {

                // Finalmente cerramos la conexión
                instruccion.close();
            }
        }

        // Devolvemos el resultado
        return resultado;

    }

    /**
     * Método que nos permite realizar actualizaciones en la base de datos
     * mediante sentencias sql
     *
     * @param sql Sentencia sql a ejecutarse
     * @return Devuelve 0 en caso de error y otro entero en caso contrario
     * @throws SQLException Si se produce un error de SQL
     */
    protected int update(String sql) throws SQLException {
        int salida;

        try {

            // Creamos una instrucción
            instruccion = DBAccess.conexion.createStatement();

            // Y la ejecutamos guardando el resultado
            salida = instruccion.executeUpdate(sql);
        } catch (SQLException e) {

            // Si se produce una excepción, reseteamos el resultado y lanzamos
            // una excepción
            salida = 0;
            throw e;
        } finally {

            // Definimos que la instrucción se cierre automaticamente cuando
            // se cierren el ResulSet asociado a ella
            instruccion.closeOnCompletion();
        }

        // Finalmente devolvemos el resultado
        return salida;
    }

    /**
     * Método que nos permite realizar una consultra a la base de datos mediante
     * una consulta sql
     *
     * @param sql Consulta sql
     * @return El resultado de la consuta en un ResulSet
     * @throws SQLException Si se produce un error de SQL
     */
    protected ResultSet query(String sql) throws SQLException {

        ResultSet salida;

        try {
            // Creamos una instrucción
            instruccion = DBAccess.conexion.createStatement();

            // Y la ejecutamos guardando el resultado
            salida = instruccion.executeQuery(sql);
        } catch (SQLException e) {

            // Si se produce una excepción, reseteamos el resultado y lanzamos
            // una excepción          
            salida = null;
            throw e;
        } finally {

            // Definimos que la instrucción se cierre automaticamente cuando
            // se cierren el ResulSet asociado a ella
            instruccion.closeOnCompletion();
        }

        // Devolvemos el resultado
        return salida;
    }
}
